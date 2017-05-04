package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.FlightDao;
import by.netcracker.artemyev.entity.Flight;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
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
    public void add(Flight object) throws ServiceException {
        try {
            flightDao.add(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void update(Flight object) throws ServiceException {
        try {
            flightDao.update(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void remove(Flight object) throws ServiceException {
        try {
            flightDao.remove(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Flight getById(int id) throws ServiceException {
        try {
            return flightDao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Flight> getAll() throws ServiceException {
        try {
            return flightDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
