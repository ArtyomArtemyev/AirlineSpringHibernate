package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.FlightDao;
import by.netcracker.artemyev.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("flightService")
public class FlightService extends GenericService<Flight> {

    @Autowired
    private FlightDao flightDao;

}
