package by.netcracker.artemyev.web.order;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Class describes controller for work with pages, which consist of information about order
 *
 * @autor Artemyev Artoym
 */
@Controller
public class OrderViewController {
    private static Logger logger = LogManager.getLogger(OrderViewController.class);

    @Autowired
    private FlightService flightService;

    /**
     * Return main page for user
     *
     * @return - ModelAndView with main user page
     */
    @RequestMapping(value = "/order/create", method = RequestMethod.GET)
    public ModelAndView getFlightsPage(HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_GET_FLIGHTS);
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.USER_MAIN;
        try {
            request.setAttribute(RequestParameter.FLIGHT, flightService.getAll());
        }  catch (ServiceException e) {
            logger.debug(e);
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), OrderViewController.class.getName());
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

}
