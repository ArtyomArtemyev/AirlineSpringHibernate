package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.dao.FlightDao;
import by.netcracker.artemyev.dao.TeamDao;
import by.netcracker.artemyev.entity.impl.Flight;
import by.netcracker.artemyev.entity.impl.Team;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.FlightService;
import by.netcracker.artemyev.service.GenericService;
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
    private static Logger logger = LogManager.getLogger(GenericService.class.getName());

    @Autowired
    private FlightDao flightDao;

    @Autowired
    private TeamDao teamDao;

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
        Flight flight = flightDao.getById(id);
        flightDao.remove(flight);
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
        Flight changeFlight = new Flight();
        changeFlight = flightDao.getById(idFlight);
        Team appointedTeam = new Team();
        appointedTeam = teamDao.getById(idTeam);
        changeFlight.setTeam(appointedTeam);
        flightDao.update(changeFlight);
    }

}
