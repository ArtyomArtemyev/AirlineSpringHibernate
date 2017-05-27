package by.netcracker.artemyev.web.User;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.RequestParameter;
import by.netcracker.artemyev.constant.ServerResponse;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.UserService;
import by.netcracker.artemyev.util.DataChecker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Class describes controller for work with entity User
 * @autor Artemyev Artoym
 */
@Controller
public class UserController {
    private static String className = UserController.class.getName();
    private static Logger logger = LogManager.getLogger(className);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "airline/user", method = RequestMethod.POST)
    @ResponseBody
    public String registrationUser(HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_REGISTRATION_USER);
        String returnText = ServerResponse.SUCCESSFUL_USER_REGISTRATION;
        boolean isValidateData = false;
        isValidateData = DataChecker.validateUserData(request.getParameter(RequestParameter.USER_LOGIN), request.getParameter(RequestParameter.USER_PASSWORD), request.getParameter(RequestParameter.USER_MAIL));
        if(isValidateData) {
            try {
                userService.createUser(request.getParameter(RequestParameter.USER_LOGIN), request.getParameter(RequestParameter.USER_PASSWORD), request.getParameter(RequestParameter.USER_MAIL));
            } catch (ServiceException e) {
                logger.debug(e);
            }
        } else {
            returnText = ServerResponse.WRONG_USER_REGISTRATION;
        }
        return returnText;
    }

}
