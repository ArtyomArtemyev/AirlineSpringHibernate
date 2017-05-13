package by.netcracker.artemyev.service;

import by.netcracker.artemyev.entity.impl.Gender;
import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

/**
 * @autor Artemyev Artoym
 */
public interface GenderService extends GeneralService<Gender> {
    void add(Gender object) throws ServiceException;
    void update(Gender object) throws ServiceException;
    void remove(Gender object) throws ServiceException;
    Gender getById(int id) throws ServiceException;
    List<Gender> getAll() throws ServiceException;
}
