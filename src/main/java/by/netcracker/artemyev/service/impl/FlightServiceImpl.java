package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.dao.FlightDao;
import by.netcracker.artemyev.entity.impl.Flight;
import by.netcracker.artemyev.service.FlightService;
import by.netcracker.artemyev.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @autor Artemyev Artoym
 */
@Service
public class FlightServiceImpl extends GenericService<Flight> implements FlightService{

    @Autowired
    private FlightDao flightDao;

}
