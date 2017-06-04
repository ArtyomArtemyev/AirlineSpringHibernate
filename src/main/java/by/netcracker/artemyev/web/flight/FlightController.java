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

    /**
     * Add new flight
     *
     * @param  - HttpServletRequest request
     * @return - String line with server response
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String addFlight(HttpServletRequest request) {
        logger.debug(LoggingName.CONTROLLER_FUNCTION_ADD_FLIGHT);
        String returnText = ServerResponse.FAIL_ADDED_FLIGHT;
        if(DataChecker.checkUserData(request.getParameter(RequestParameter.NAVIGATION_FLIGHT))) {
            try {
                flightService.createFlight(request.getParameter(RequestParameter.NAVIGATION_FLIGHT));
                returnText = ServerResponse.ADDED_FLIGHT;
            }  catch (ServiceException e) {
                logger.debug(e);
            }
        }
        return returnText;
    }

    /**
     * Delete current flight
     *
     * @param  - String id flight for deleting
     * @return - String line with server response
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteFlight(@PathVariable("id") String id) {
        logger.debug(LoggingName.CONTROLLER_FUNCTION_DELETE_FLIGHT);
        String returnText = ServerResponse.FAIL_DELETED_FLIGHT;
        try {
            flightService.deleteFlight(Long.parseLong(id));
            returnText = ServerResponse.DELETED_FLIGHT;
        }  catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

    /**
     * Update current flight
     *
     * @param  - String id flight for deleting, String json with new flight navigation
     * @return - String line with server response
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String updateFlight(@PathVariable("id") String id, @RequestBody String json) {
        logger.debug(LoggingName.CONTROLLER_FUNCTION_EDIT_FLIGHT);
        String returnText = ServerResponse.FAIL_EDITED_FLIGHT;
        if(DataChecker.checkUserData(json)) {
            JSONObject jsonObject = new JSONObject(json);
            try {
                flightService.changeFlightNavigation(Long.valueOf(id), jsonObject.getString(FIELD_NAVIGATION));
                returnText = ServerResponse.EDITED_FLIGHT;
            } catch (ServiceException e) {
                logger.debug(e);
            }
        }
        return returnText;
    }

}
