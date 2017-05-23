package by.netcracker.artemyev.web;

import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.constant.RequestParameter;
import by.netcracker.artemyev.constant.ServerResponse;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.FlightService;
import by.netcracker.artemyev.util.ErrorHandler;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView showFlights(HttpServletRequest request, HttpServletResponse response) {
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

    @RequestMapping(value = prefix + "flights/{id}", method = RequestMethod.GET)
    public ModelAndView showFlight(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.ABOUT_FLIGHT;
        try {
            request.setAttribute(RequestParameter.ABOUT_FLIGHT, flightService.getById(Long.valueOf(id)));
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

    @RequestMapping(value = prefix + "/flights", method = RequestMethod.POST)
    @ResponseBody
    public String addFlight(HttpServletRequest request, HttpServletResponse response) {
        String returnText = ServerResponse.ADD_FLIGHT;
        try {
            flightService.addFlight(request.getParameter(RequestParameter.NAVIGATION_FLIGHT));
        }  catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

    @RequestMapping(value = prefix + "/flights/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteFlight(@PathVariable("id") String id) {
        String returnText = ServerResponse.DELETE_FLIGHT;
        try {
            flightService.deleteFlight(Long.parseLong(id));
        }  catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

    @RequestMapping(value = prefix + "/flights/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String updateFlight(@PathVariable("id") String id,@RequestBody String json) {
        String returnText = ServerResponse.EDIT_FLIGHT;
        JSONObject jsonObject = new JSONObject(json);
        try {
            flightService.changeFlightNavigation(Long.valueOf(jsonObject.getString("id")),jsonObject.getString("navigation"));
        } catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }


}
