package by.netcracker.artemyev.web.flight;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.RequestParameter;
import by.netcracker.artemyev.constant.ServerResponse;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.FlightService;
import by.netcracker.artemyev.util.DataChecker;
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
 *
 * @autor Artemyev Artoym
 */
@Controller
@RequestMapping("/flights")
public class FlightController {
    private static Logger logger = LogManager.getLogger(FlightController.class);
    private static final String FIELD_NAVIGATION = "navigation";

    @Autowired
    private FlightService flightService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String addFlight(HttpServletRequest request) {
        logger.debug(LoggingName.FUNCTION_ADD_FLIGHT);
        String returnText = ServerResponse.ADD_FLIGHT;
        if(DataChecker.checkUserData(request.getParameter(RequestParameter.NAVIGATION_FLIGHT))) {
            try {
                flightService.createFlight(request.getParameter(RequestParameter.NAVIGATION_FLIGHT));
            }  catch (ServiceException e) {
                logger.debug(e);
            }
        } else {
            returnText = ServerResponse.ADD_NOT_FLIGHT;
        }
        return returnText;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
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

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String updateFlight(@PathVariable("id") String id, @RequestBody String json) {
        logger.debug(LoggingName.FUNCTION_EDIT_FLIGHT);
        String returnText = ServerResponse.EDIT_FLIGHT;
        if(DataChecker.checkUserData(json)) {
            JSONObject jsonObject = new JSONObject(json);
            try {
                flightService.changeFlightNavigation(Long.valueOf(id), jsonObject.getString(FIELD_NAVIGATION));
            } catch (ServiceException e) {
                logger.debug(e);
            }
        } else {
            returnText = ServerResponse.EDIT_NOT_FLIGHT;
        }
        return returnText;
    }

}
