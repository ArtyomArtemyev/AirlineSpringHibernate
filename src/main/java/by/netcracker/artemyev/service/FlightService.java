package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.FlightDao;
import by.netcracker.artemyev.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("flightService")
public class FlightService implements GeneralService<Flight> {

    @Autowired
    private FlightDao flightDao;

    @Transactional
    @Override
    public void add(Flight object) {
     flightDao.add(object);
    }

    @Transactional
    @Override
    public void update(Flight object) {
        flightDao.update(object);
    }

    @Transactional
    @Override
    public void remove(Flight object) {
        flightDao.remove(object);
    }

    @Transactional(readOnly = true)
    @Override
    public Flight getById(int id) {
        return flightDao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Flight> getAll() {
        return flightDao.getAll();
    }

}
