package by.netcracker.artemyev.web;

import by.netcracker.artemyev.constant.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @autor Artemyev Artoym
 */
@Controller
public class MainController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Page.INDEX);
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView getRegistration() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Page.REGISTRATION);
        return modelAndView;
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public ModelAndView getAuthorization() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Page.AUTHORIZATION);
        return modelAndView;
    }

}
