package by.netcracker.artemyev.web;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.constant.RequestParameter;
import by.netcracker.artemyev.constant.ServerResponse;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Class describes controller for work with entity User
 * @autor Artemyev Artoym
 */
@Controller
public class UserController {
    private static String className = UserController.class.getName();
    private static Logger logger = LogManager.getLogger(UserController.class);
    private final String prefix = "/airline/";

    @Autowired
    private UserService userService;

    @RequestMapping(value = prefix +"user/check", method = RequestMethod.POST)
    public ModelAndView authorizationUser(HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_AUTHORIZATION_USER);
        ModelAndView modelAndView = new ModelAndView();
        String returnPage;
        boolean isValidateData = false;
        isValidateData = DataChecker.validateUserData(request.getParameter(RequestParameter.USER_LOGIN), request.getParameter(RequestParameter.USER_PASSWORD));
        if(isValidateData) {
            try {
                returnPage = userService.checkUser(request.getParameter(RequestParameter.USER_LOGIN), request.getParameter(RequestParameter.USER_PASSWORD));
            } catch (ServiceException e) {
                logger.debug(e);
                returnPage = ErrorHandler.returnErrorPage(e.getMessage(), className);
            }
        } else {
            returnPage = Page.ERROR;
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

    @RequestMapping(value = prefix + "user", method = RequestMethod.POST)
    @ResponseBody
    public String registrationUser(HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_REGISTRATION_USER);
        String returnText = ServerResponse.SUCCESSFUL_USER_REGISTRATION;
        boolean isValidateData = false;
        isValidateData = DataChecker.validateUserData(request.getParameter(RequestParameter.USER_LOGIN), request.getParameter(RequestParameter.USER_PASSWORD), request.getParameter(RequestParameter.USER_MAIL));
        if(isValidateData) {
            try {
                userService.addUser(request.getParameter(RequestParameter.USER_LOGIN), request.getParameter(RequestParameter.USER_PASSWORD), request.getParameter(RequestParameter.USER_MAIL));
            } catch (ServiceException e) {
                logger.debug(e);
            }
        } else {
            returnText = ServerResponse.WRONG_USER_REGISTRATION;
        }
        return returnText;
    }

}
