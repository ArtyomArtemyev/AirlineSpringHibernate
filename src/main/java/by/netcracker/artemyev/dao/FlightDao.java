package by.netcracker.artemyev.dao;


import by.netcracker.artemyev.entity.impl.Flight;
import by.netcracker.artemyev.exception.DaoException;

public interface FlightDao extends GeneralDao<Flight> {
    void add(Flight object) throws DaoException;
    void update(Flight object) throws DaoException;
    void remove(Flight object) throws DaoException;
    Flight getById(int id) throws DaoException;
}
