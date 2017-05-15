package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.dao.FlightDao;
import by.netcracker.artemyev.entity.impl.Flight;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.FlightService;
import by.netcracker.artemyev.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @autor Artemyev Artoym
 */
@Service
public class FlightServiceImpl extends GenericService<Flight> implements FlightService{

    @Autowired
    private FlightDao flightDao;

    @Transactional
    @Override
    public void addFlight(String navigation) throws ServiceException {
        Flight flight = new Flight(navigation, null);
        this.add(flight);
    }

    @Transactional
    @Override
    public void deleteFlight(Long id) throws ServiceException {
        Flight flight = flightDao.getById(id);
        flightDao.remove(flight);
    }

}
