package by.netcracker.artemyev.web.Team;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.ServerResponse;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.FlightService;
import by.netcracker.artemyev.service.TeamService;
import by.netcracker.artemyev.util.Converter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class describes controller for work with entity Team
 * @autor Artemyev Artoym
 */
@Controller
public class TeamController {
    private static String className = TeamController.class.getName();
    private static Logger logger = LogManager.getLogger(className);

    @Autowired
    private TeamService teamService;

    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "airline/teams", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String addTeam(@RequestBody String json) {
        logger.debug(LoggingName.FUNCTION_ADD_TEAM);
        String returnText = ServerResponse.ADD_TEAM;
        List<Long> idList = new ArrayList<>();
        idList = Converter.convertToList(json);
        try {
            teamService.createTeam(idList);
        } catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

    @RequestMapping(value = "airline/teams/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String appointTeam(@PathVariable String id, @RequestBody String json) {
        logger.debug(LoggingName.FUNCTION_APPOINT_TEAM);
        String returnText = ServerResponse.APPOINTMENT_TEAM;
        try {
            flightService.appointTeam(Long.valueOf(json), Long.valueOf(id));
        } catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

    @RequestMapping(value = "airline/teams/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTeam(@PathVariable("id") String id) {
        logger.debug(LoggingName.FUNCTION_DELETE_TEAM);
        String returnText = ServerResponse.DELETE_TEAM;
        try {
            boolean isTeamAppointToFlight = teamService.checkAppointingTeamToFlight(Long.valueOf(id));
            logger.info(isTeamAppointToFlight);
            if(isTeamAppointToFlight) {
                returnText = ServerResponse.CAN_NOT_DELETE_TEAM;
            } else {
                teamService.deleteTeam(Long.parseLong(id));
            }
        }  catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

}
