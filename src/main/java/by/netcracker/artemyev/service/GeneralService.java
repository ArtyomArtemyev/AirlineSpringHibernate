package by.netcracker.artemyev.service;

import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

/**
 * @autor Artemyev Artoym
 */
public interface GeneralService<T> {
    void add(T object) throws ServiceException;
    void update(T object) throws ServiceException;
    void remove(T object) throws ServiceException;
    T getById(Long id) throws ServiceException;
    List<T> getAll() throws ServiceException;
}
