package by.netcracker.artemyev.service;

import by.netcracker.artemyev.entity.impl.Flight;
import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

/**
 * @autor Artemyev Artoym
 */
public interface FlightService extends GeneralService<Flight> {
    void add(Flight object) throws ServiceException;
    void update(Flight object) throws ServiceException;
    void remove(Flight object) throws ServiceException;
    Flight getById(Long id) throws ServiceException;
    List<Flight> getAll() throws ServiceException;
    void addFlight(String navigation) throws ServiceException;
    void deleteFlight(Long id) throws ServiceException;
    void changeFlightNavigation(Long id, String navigation) throws ServiceException;
    void appointTeam(Long idFlight, Long idTeam) throws ServiceException;
}
