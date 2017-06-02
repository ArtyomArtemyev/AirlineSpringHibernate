package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.dao.FlightDao;
import by.netcracker.artemyev.entity.impl.Airplane;
import by.netcracker.artemyev.entity.impl.Flight;
import by.netcracker.artemyev.entity.impl.Team;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.AirplaneService;
import by.netcracker.artemyev.service.FlightService;
import by.netcracker.artemyev.service.GenericService;
import by.netcracker.artemyev.service.TeamService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @autor Artemyev Artoym
 */
@Service
public class FlightServiceImpl extends GenericService<Flight> implements FlightService {
    private static Logger logger = LogManager.getLogger(GenericService.class);

    @Autowired
    private FlightDao flightDao;

    @Autowired
    private TeamService teamService;

    @Autowired
    private AirplaneService airplaneService;

    @Transactional
    @Override
    public void createFlight(String navigation) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_CREATE_FLIGHT);
        Flight flight = new Flight(navigation, null);
        this.add(flight);
    }

    @Transactional
    @Override
    public void deleteFlight(Long id) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_REMOVE_FLIGHT);
        try {
            Flight flight = flightDao.getById(id);
            flightDao.remove(flight);
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void changeFlightNavigation(Long id, String navigation) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_CHANGE_FLIGHT_NAVIGATION);
        Flight changeFlight = new Flight();
        changeFlight.setId(id);
        changeFlight.setNavigation(navigation);
        this.update(changeFlight);
    }

    @Transactional
    @Override
    public void appointTeam(Long idFlight, Long idTeam) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_APPOINT_TEAM_TO_FLIGHT);
        try {
            Flight changeFlight = flightDao.getById(idFlight);
            Team appointedTeam = teamService.getById(idTeam);
            changeFlight.setTeam(appointedTeam);
            flightDao.update(changeFlight);
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void appointAirplane(Long idFlight, Long idAirplane) throws ServiceException {
        try {
            Flight flight = flightDao.getById(idFlight);
            Airplane airplane = airplaneService.getById(idAirplane);
            flight.setAirplane(airplane);
            flightDao.update(flight);
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
    }

}
