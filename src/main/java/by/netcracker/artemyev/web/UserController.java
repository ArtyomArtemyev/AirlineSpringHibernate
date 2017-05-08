package by.netcracker.artemyev.web;

import by.netcracker.artemyev.constant.Page;
import by.netcracker.artemyev.constant.RequestParameter;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.UserService;
import by.netcracker.artemyev.util.ErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    private static String className = UserController.class.getName();

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/check_user", method = RequestMethod.POST)
    public ModelAndView authorizationUser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String returnPage;
        try {
            returnPage = userService.checkUser(request.getParameter(RequestParameter.USER_LOGIN), request.getParameter(RequestParameter.USER_PASSWORD));
        } catch (ServiceException e) {
            returnPage = ErrorHandler.returnErrorPage(e.getMessage(), className);
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public ModelAndView registrationUser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String returnPage = Page.SUCCESSFUL_REGISTRATION;
        try {
            userService.addUser(request.getParameter(RequestParameter.USER_LOGIN), request.getParameter(RequestParameter.USER_PASSWORD), request.getParameter(RequestParameter.USER_MAIL));
        }  catch (ServiceException e) {
           returnPage = ErrorHandler.returnErrorPage(e.getMessage(), className);
        }
        modelAndView.setViewName(returnPage);
        return modelAndView;
    }

}
