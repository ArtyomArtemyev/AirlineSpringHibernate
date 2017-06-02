package by.netcracker.artemyev.web.team;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.constant.RequestAttribute;
import by.netcracker.artemyev.entity.impl.Flight;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.AirplaneService;
import by.netcracker.artemyev.service.EmployeeService;
import by.netcracker.artemyev.service.FlightService;
import by.netcracker.artemyev.service.TeamService;
import by.netcracker.artemyev.util.ErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Class describes controller for work with pages, which consist of information about team
 * @autor Artemyev Artoym
 */
@Controller
public class TeamViewController {
    private static Logger logger = LogManager.getLogger(TeamViewController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirplaneService airplaneService;

    @RequestMapping(value = "/team/delete", method = RequestMethod.GET)
    public ModelAndView getDeleteTeamPage(HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_GET_DELETE_TEAM_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.DELETE_TEAM;
        try {
            request.setAttribute(RequestAttribute.TEAMS, teamService.getTeamDto());
        }  catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), TeamViewController.class.getName());
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

    @RequestMapping(value = "team/create", method = RequestMethod.GET)
    public ModelAndView getFlightsPage(HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_GET_TEAMS_AND_FLIGHTS_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.APPOINT_TEAM;
        try {
            request.setAttribute(RequestAttribute.LIST_FLIGHTS, flightService.getAll());
        } catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), TeamViewController.class.getName());
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

    @RequestMapping(value = "/team/flight/update/{id}", method = RequestMethod.GET)
    public ModelAndView getFlightAndEmployeesPage(@PathVariable String id, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.CREATE_TEAM_TO_FLIGHT;
        try {
            Flight flight = flightService.getById(Long.valueOf(id));
            request.setAttribute(RequestAttribute.EMPLOYEES, employeeService.getAll());
            request.setAttribute(RequestAttribute.FLIGHT, flight);
            String typeTeam = airplaneService.getTypeTeam(flight.getAirplane().getId());
            request.setAttribute(RequestAttribute.ID_AIRPLANE, flight.getAirplane().getId());
        } catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), TeamViewController.class.getName());
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }


    @RequestMapping(value = "team/employee", method = RequestMethod.GET)
    public ModelAndView getEmployeesPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = "dispatcherShowEmployees";
        try {
            request.setAttribute(RequestAttribute.EMPLOYEES, employeeService.getAll());
        } catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), TeamViewController.class.getName());
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

}
