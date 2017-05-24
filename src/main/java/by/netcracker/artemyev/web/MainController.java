package by.netcracker.artemyev.web;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class describes controller for common common application pages
 * @autor Artemyev Artoym
 */
@Controller
public class MainController {
    private static Logger logger = LogManager.getLogger(MainController.class.getName());
    private final String prefix = "/airline/";

    @RequestMapping(value = prefix + "index", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        logger.debug(LoggingName.FUNCTION_GET_INDEX_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Page.INDEX);
        return modelAndView;
    }

    @RequestMapping(value = prefix + "registration", method = RequestMethod.GET)
    public ModelAndView getRegistration() {
        logger.debug(LoggingName.FUNCTION_GET_REGISTRATION_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Page.REGISTRATION);
        return modelAndView;
    }

    @RequestMapping(value = prefix + "authorization", method = RequestMethod.GET)
    public ModelAndView getAuthorization() {
        logger.debug(LoggingName.FUNCTION_GET_AUTHORIZATION_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Page.AUTHORIZATION);
        return modelAndView;
    }

    @RequestMapping(value = prefix + "chart", method = RequestMethod.GET)
    public ModelAndView getChart() {
        logger.debug(LoggingName.FUNCTION_GET_CHART_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Page.INFORMATION_CHART);
        return modelAndView;
    }

}
