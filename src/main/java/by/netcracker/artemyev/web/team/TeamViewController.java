package by.netcracker.artemyev.web.team;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.constant.RequestParameter;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.EmployeeService;
import by.netcracker.artemyev.service.FlightService;
import by.netcracker.artemyev.service.TeamService;
import by.netcracker.artemyev.util.ErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private static String className = TeamViewController.class.getName();
    private static Logger logger = LogManager.getLogger(className);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "/team/create", method = RequestMethod.GET)
    public ModelAndView getCreateTeamPage(HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_GET_CREATE_TEAM_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.CREATE_TEAM;
        try {
            request.setAttribute(RequestParameter.EMPLOYEES, employeeService.getAll());
        }  catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), className);
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

    @RequestMapping(value = "/team/delete", method = RequestMethod.GET)
    public ModelAndView getDeleteTeamPage(HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_GET_DELETE_TEAM_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.DELETE_TEAM;
        try {
            request.setAttribute("teams", teamService.getTeamDto());
        }  catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), className);
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

    @RequestMapping(value = "team/appointment", method = RequestMethod.GET)
    public ModelAndView getTeamsAndFlights(HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_GET_TEAMS_AND_FLIGHTS_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.APPOINT_TEAM;
        try {
            request.setAttribute("listTeam", teamService.getAll());
            request.setAttribute("listFlight", flightService.getAll());
        }  catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), className);
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

}
