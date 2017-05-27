package by.netcracker.artemyev.web.Flight;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.RequestParameter;
import by.netcracker.artemyev.constant.ServerResponse;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.FlightService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Class describes controller for work with entity Flight
 * @autor Artemyev Artoym
 */
@Controller
public class FlightController {
    private static String className = FlightController.class.getName();
    private static Logger logger = LogManager.getLogger(className);

    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "airline/flights", method = RequestMethod.POST)
    @ResponseBody
    public String addFlight(HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_ADD_FLIGHT);
        String returnText = ServerResponse.ADD_FLIGHT;
        try {
            flightService.createFlight(request.getParameter(RequestParameter.NAVIGATION_FLIGHT));
        }  catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

    @RequestMapping(value = "airline/flights/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteFlight(@PathVariable("id") String id) {
        logger.debug(LoggingName.FUNCTION_DELETE_FLIGHT);
        String returnText = ServerResponse.DELETE_FLIGHT;
        try {
            flightService.deleteFlight(Long.parseLong(id));
        }  catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

    @RequestMapping(value = "airline/flights/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String updateFlight(@PathVariable("id") String id, @RequestBody String json) {
        logger.debug(LoggingName.FUNCTION_EDIT_FLIGHT);
        String returnText = ServerResponse.EDIT_FLIGHT;
        JSONObject jsonObject = new JSONObject(json);
        try {
            flightService.changeFlightNavigation(Long.valueOf(id),jsonObject.getString("navigation"));
        } catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

}
