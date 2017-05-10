package by.netcracker.artemyev.dao;


import by.netcracker.artemyev.entity.impl.Gender;
import by.netcracker.artemyev.exception.DaoException;

public interface GenderDao extends GeneralDao<Gender> {
    void add(Gender object) throws DaoException;
    void update(Gender object) throws DaoException;
    void remove(Gender object) throws DaoException;
    Gender getById(int id) throws DaoException;
}
