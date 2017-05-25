package by.netcracker.artemyev.web;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.constant.RequestParameter;
import by.netcracker.artemyev.constant.ServerResponse;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.EmployeeService;
import by.netcracker.artemyev.service.FlightService;
import by.netcracker.artemyev.service.TeamService;
import by.netcracker.artemyev.util.Converter;
import by.netcracker.artemyev.util.ErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Class describes controller for work with entity Team
 * @autor Artemyev Artoym
 */
@Controller
public class TeamController {
    private static String className = TeamController.class.getName();
    private static Logger logger = LogManager.getLogger(FlightController.class.getName());
    private final String prefix = "/airline/";

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private FlightService flightService;

    @RequestMapping(value = prefix + "team/create", method = RequestMethod.GET)
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

    @RequestMapping(value = prefix + "team/delete", method = RequestMethod.GET)
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

    @RequestMapping(value = prefix + "/team", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addTeam(@RequestBody String json) {
        logger.debug(LoggingName.FUNCTION_ADD_TEAM);
        String returnText = ServerResponse.ADD_TEAM;
        List<Long> idList = new ArrayList<>();
        idList = Converter.convertToList(json);
        try {
            teamService.createTeam(idList);
        } catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

    @RequestMapping(value = prefix + "/team/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String appointTeam(@PathVariable String id, @RequestBody String json) {
        logger.debug(LoggingName.FUNCTION_APPOINT_TEAM);
        String returnText = ServerResponse.APPOINTMENT_TEAM;
        try {
            flightService.appointTeam(Long.valueOf(json), Long.valueOf(id));
        } catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

    @RequestMapping(value = prefix + "team/appointment", method = RequestMethod.GET)
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

    @RequestMapping(value = prefix + "/team/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTeam(@PathVariable("id") String id) {
        logger.debug(LoggingName.FUNCTION_DELETE_TEAM);
        String returnText = ServerResponse.DELETE_TEAM;
        try {
            boolean isTeamAppointToFlight = teamService.checkAppointingTeamToFlight(Long.valueOf(id));
            logger.info(isTeamAppointToFlight);
            if(isTeamAppointToFlight) {
                returnText = ServerResponse.CAN_NOT_DELETE_TEAM;
            } else {
                teamService.deleteTeam(Long.parseLong(id));
            }
        }  catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

}
