package by.netcracker.artemyev.web.airplane;

import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.AirplaneService;
import by.netcracker.artemyev.service.FlightService;
import by.netcracker.artemyev.util.ErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AirplaneViewController {
    private static String className = AirplaneViewController.class.getName();
    private static Logger logger = LogManager.getLogger(className);

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirplaneService airplaneService;

    @RequestMapping(value = "/airplane/appointment", method = RequestMethod.GET)
    public ModelAndView manageFlight(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.APPOINT_AIRPLANE;
        try {
            request.setAttribute("listFlight", flightService.getAll());
            request.setAttribute("listAirplanes", airplaneService.getAll());
        }  catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), className);
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }
}
