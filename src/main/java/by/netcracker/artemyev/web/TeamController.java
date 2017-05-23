package by.netcracker.artemyev.web;

import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.constant.RequestParameter;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.EmployeeService;
import by.netcracker.artemyev.service.TeamService;
import by.netcracker.artemyev.util.Converter;
import by.netcracker.artemyev.util.ErrorHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor Artemyev Artoym
 */
@Controller
public class TeamController {
    private static String className = TeamController.class.getName();
    private static Logger logger = Logger.getLogger(FlightController.class.getName());
    private final String prefix = "/airline/";

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = prefix + "team/management", method = RequestMethod.GET)
    public ModelAndView showEmployees(HttpServletRequest request, HttpServletResponse response) {
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

    @RequestMapping(value = prefix + "/team", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addTeam(@RequestBody String json) {
        String returnText = "Team added successful";
        List<Long> idList = new ArrayList<>();
        idList = Converter.fromWebJson(json);
        try {
            teamService.createTeam(idList);
        } catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

}
