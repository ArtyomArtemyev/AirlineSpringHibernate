package by.netcracker.artemyev.web.airplane;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.constant.RequestAttribute;
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

/**
 * Class describes controller for work with pages, which consist of information about airplane
 * @autor Artemyev Artoym
 */
@Controller
public class AirplaneViewController {
    private static Logger logger = LogManager.getLogger(AirplaneViewController.class);

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirplaneService airplaneService;

    /**
     * Get page for appointing airplane to flight
     *
     * @param  - HttpServletRequest
     * @return - ModelAndView with page for creating team
     */
    @RequestMapping(value = "/airplane/appointment", method = RequestMethod.GET)
    public ModelAndView getAppointmentAirplanePage(HttpServletRequest request) {
        logger.debug(LoggingName.CONTROLLER_FUNCTION_APPOINTMENT_AIRPLANE);
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.APPOINT_AIRPLANE;
        try {
            request.setAttribute(RequestAttribute.LIST_FLIGHTS, flightService.getAll());
            request.setAttribute(RequestAttribute.LIST_AIRPLANES, airplaneService.getAll());
        }  catch (ServiceException e) {
            logger.error(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), AirplaneViewController.class.getName());
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }
}
