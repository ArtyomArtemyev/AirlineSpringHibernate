package by.netcracker.artemyev.service;


import by.netcracker.artemyev.entity.impl.Airplane;
import by.netcracker.artemyev.exception.ServiceException;

/**
 * @autor Artemyev Artoym
 */
public interface AirplaneService extends GeneralService<Airplane> {
    String getTypeTeam(Long idAirplane) throws ServiceException;
}
