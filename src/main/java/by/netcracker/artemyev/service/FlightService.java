package by.netcracker.artemyev.service;

import by.netcracker.artemyev.entity.impl.Flight;
import by.netcracker.artemyev.exception.ServiceException;

/**
 * @autor Artemyev Artoym
 */
public interface FlightService extends GeneralService<Flight> {
    void createFlight(String navigation) throws ServiceException;
    void deleteFlight(Long id) throws ServiceException;
    void changeFlightNavigation(Long id, String navigation) throws ServiceException;
    void appointTeam(Long idFlight, Long idTeam) throws ServiceException;
    void appointAirplane(Long idFlight, Long idTeam) throws ServiceException;
}
