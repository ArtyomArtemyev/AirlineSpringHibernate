package by.netcracker.artemyev.service;

import by.netcracker.artemyev.entity.Flight;
import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

public interface FlightService extends GeneralService<Flight> {
    void add(Flight object) throws ServiceException;
    void update(Flight object) throws ServiceException;
    void remove(Flight object) throws ServiceException;
    Flight getById(int id) throws ServiceException;
    List<Flight> getAll() throws ServiceException;
}
