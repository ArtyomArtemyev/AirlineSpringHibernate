package by.netcracker.artemyev.web;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.constant.RequestAttribute;
import by.netcracker.artemyev.constant.RequestParameter;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.UserService;
import by.netcracker.artemyev.util.DataChecker;
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
 * Class describes controller for common application pages
 * @autor Artemyev Artoym
 */
@Controller
public class MainViewController {
    private static Logger logger = LogManager.getLogger(MainViewController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getIndexPage() {
        logger.debug(LoggingName.FUNCTION_GET_INDEX_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Page.INDEX);
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView getRegistrationPage() {
        logger.debug(LoggingName.FUNCTION_GET_REGISTRATION_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Page.REGISTRATION);
        return modelAndView;
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public ModelAndView getAuthorizationPage() {
        logger.debug(LoggingName.FUNCTION_GET_AUTHORIZATION_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Page.AUTHORIZATION);
        return modelAndView;
    }

    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    public ModelAndView getChartPage() {
        logger.debug(LoggingName.FUNCTION_GET_CHART_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Page.INFORMATION_CHART);
        return modelAndView;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView getContactPage() {
        logger.debug(LoggingName.FUNCTION_GET_CONTACT_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Page.CONTACT);
        return modelAndView;
    }

    @RequestMapping(value = "/user/check", method = RequestMethod.POST)
    public ModelAndView getUserPage(HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_GET_USER_PAGE);
        ModelAndView modelAndView = new ModelAndView();
        String returnPage;
        boolean isValidateData = false;
        isValidateData = DataChecker.validateUserData(request.getParameter(RequestParameter.USER_LOGIN), request.getParameter(RequestParameter.USER_PASSWORD));
        if(isValidateData) {
            try {
                returnPage = userService.checkUser(request.getParameter(RequestParameter.USER_LOGIN), request.getParameter(RequestParameter.USER_PASSWORD), request.getSession());
                if(returnPage.equals(Page.USER_INDEX)) {
                    request.setAttribute(RequestAttribute.ID_USER, userService.getByLoginAndPassword(request.getParameter(RequestParameter.USER_LOGIN), request.getParameter(RequestParameter.USER_PASSWORD)));
                }
            } catch (ServiceException e) {
                logger.debug(e);
                returnPage = ErrorHandler.returnErrorPage(e.getMessage(), MainViewController.class.getName());
            }
        } else {
            returnPage = Page.ERROR;
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView getLogoutPage(HttpServletRequest request) {
        request.removeAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Page.INDEX);
        return modelAndView;
    }

}
