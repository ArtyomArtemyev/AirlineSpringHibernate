package by.netcracker.artemyev.service;


import by.netcracker.artemyev.entity.impl.Airplane;
import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

/**
 * @autor Artemyev Artoym
 */
public interface AirplaneService extends GeneralService<Airplane> {
    void add(Airplane object) throws ServiceException;
    void update(Airplane object) throws ServiceException;
    void remove(Airplane object) throws ServiceException;
    Airplane getById(Long id) throws ServiceException;
    List<Airplane> getAll() throws ServiceException;
}
