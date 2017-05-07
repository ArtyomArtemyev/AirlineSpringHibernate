package by.netcracker.artemyev.web;

import by.netcracker.artemyev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    private final static String USER_LOGIN = "login";
    private final static String USER_PASSWORD = "password";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/check_user", method = RequestMethod.POST)
    public ModelAndView authorizationUser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String userPage = userService.checkUser(request.getParameter(USER_LOGIN), request.getParameter(USER_PASSWORD));
        modelAndView.setViewName(userPage);
        return modelAndView;
    }

}
