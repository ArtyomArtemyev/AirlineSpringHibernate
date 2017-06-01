package by.netcracker.artemyev.web.airplane;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.ServerResponse;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.AirplaneService;
import by.netcracker.artemyev.service.FlightService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/airplane")
public class AirplaneController {
    private static String className = AirplaneViewController.class.getName();
    private static Logger logger = LogManager.getLogger(className);
    private static final String FIELD_ID_FLIGHT = "idFlight";

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "/{id}/team", method = RequestMethod.GET)
    public @ResponseBody String updateFlight(@PathVariable("id") String id) {
        String returnText = ServerResponse.EDIT_FLIGHT;
        try {
            returnText = airplaneService.getTypeTeam(Long.valueOf(id));
        } catch (ServiceException e) {

        }
        return returnText;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String appointAirplane(@PathVariable("id") String id, @RequestBody String json) {
        logger.debug(LoggingName.FUNCTION_EDIT_FLIGHT);
        String returnText = ServerResponse.APPOINT_AIRPLANE;
        JSONObject jsonObject = new JSONObject(json);
        try {
            flightService.appointAirplane(Long.valueOf(jsonObject.getString(FIELD_ID_FLIGHT)), Long.valueOf(id));
        } catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

}
