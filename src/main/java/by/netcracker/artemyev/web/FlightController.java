package by.netcracker.artemyev.web;

import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.constant.RequestParameter;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.FlightService;
import by.netcracker.artemyev.util.ErrorHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @autor Artemyev Artoym
 */
@Controller
public class FlightController {
    private static String className = FlightController.class.getName();
    private static Logger logger = Logger.getLogger(FlightController.class.getName());
    private final String prefix = "/airline/";

    @Autowired
    private FlightService flightService;

    @RequestMapping(value = prefix + "flights", method = RequestMethod.GET)
    public ModelAndView getFlight(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.USER_MAIN;
        try {
            request.setAttribute(RequestParameter.FLIGHT, flightService.getAll());
        }  catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), className);
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

    @RequestMapping(value = prefix + "flight/management", method = RequestMethod.GET)
    public ModelAndView manageFlight(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.ADMIN_MAIN;
        try {
            request.setAttribute(RequestParameter.FLIGHT, flightService.getAll());
        }  catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), className);
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

    @RequestMapping(value = prefix + "/flight/add", method = RequestMethod.POST)
    public ModelAndView addFlight(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.SUCCESSFUL_ADD_FLIGHT;
        try {
            flightService.addFlight(request.getParameter(RequestParameter.NAVIGATION_FLIGHT));
        }  catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), className);
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

    @RequestMapping(value = prefix + "/flight/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteFlight(@PathVariable("id") String id) {
        String returnText = "Flight was deleted successful";
        try {
            flightService.deleteFlight(Long.parseLong(id));
        }  catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

}
