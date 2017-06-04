package by.netcracker.artemyev.web.flight;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.constant.RequestParameter;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.FlightService;
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
 * Class describes controller for work with pages, which consist of information about flight
 * @autor Artemyev Artoym
 */
@Controller
public class FlightViewController {
    private static Logger logger = LogManager.getLogger(FlightViewController.class);

    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "/flights/registration", method = RequestMethod.GET)
    public ModelAndView getFlightsPage(HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_GET_FLIGHTS);
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.USER_MAIN;
        try {
            request.setAttribute(RequestParameter.FLIGHT, flightService.getAll());
        }  catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), FlightViewController.class.getName());
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

    @RequestMapping(value = "airline/flights/{id}", method = RequestMethod.GET)
    public ModelAndView aboutFlightPage(@PathVariable("id") String id, HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_GET_FLIGHT);
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.ABOUT_FLIGHT;
        try {
            request.setAttribute(RequestParameter.ABOUT_FLIGHT, flightService.getById(Long.valueOf(id)));
        }  catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), FlightViewController.class.getName());
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

    @RequestMapping(value = "/flights/management", method = RequestMethod.GET)
    public ModelAndView manageFlightsPage(HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_GET_FLIGHT_MANAGEMENT_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.ADMIN_MAIN;
        try {
            request.setAttribute(RequestParameter.FLIGHT, flightService.getAll());
        }  catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), FlightViewController.class.getName());
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

}
