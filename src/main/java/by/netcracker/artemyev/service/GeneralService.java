package by.netcracker.artemyev.service;

import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

public interface GeneralService<T> {
    void add(T object) throws ServiceException;
    void update(T object) throws ServiceException;
    void remove(T object) throws ServiceException;
    T getById(int id) throws ServiceException;
    List<T> getAll() throws ServiceException;
}
