package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.exception.DaoException;

/**
 * Interface describes common functions for all dao
 * @autor Artemyev Artoym
 */
public interface GeneralDao<T> {
    void add(T object) throws DaoException;
    void update(T object) throws DaoException;
    void remove(T object) throws DaoException;
    T getById(int id) throws DaoException;
}
