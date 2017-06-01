package by.netcracker.artemyev.web.airplane;

import by.netcracker.artemyev.constant.ServerResponse;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.AirplaneService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AirplaneController {
    private static String className = AirplaneViewController.class.getName();
    private static Logger logger = LogManager.getLogger(className);

    @Autowired
    private AirplaneService airplaneService;

    @RequestMapping(value = "airline/airplane/{id}/team", method = RequestMethod.GET)
    public @ResponseBody String updateFlight(@PathVariable("id") String id) {
        String returnText = ServerResponse.EDIT_FLIGHT;
        try {
            returnText = airplaneService.getTypeTeam(Long.valueOf(id));
        } catch (ServiceException e) {

        }
        return returnText;
    }
}
