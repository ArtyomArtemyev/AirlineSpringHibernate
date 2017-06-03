package by.netcracker.artemyev.web.airplane;

import by.netcracker.artemyev.constant.ServerResponse;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.AirplaneService;
import by.netcracker.artemyev.service.FlightService;
import by.netcracker.artemyev.util.DataChecker;
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
    private static Logger logger = LogManager.getLogger(AirplaneViewController.class);
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
            logger.debug(e);
        }
        return returnText;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String appointAirplane(@PathVariable("id") String id, @RequestBody String json) {
        String returnText = ServerResponse.APPOINT_AIRPLANE;
        if(DataChecker.checkUserData(json)) {
            JSONObject jsonObject = new JSONObject(json);
            try {
                flightService.appointAirplane(Long.valueOf(jsonObject.getString(FIELD_ID_FLIGHT)), Long.valueOf(id));
            } catch (ServiceException e) {
                logger.debug(e);
            }
        } else {
            returnText = ServerResponse.NO_APPOINT_AIRPLANE;
        }
        return returnText;
    }

}
