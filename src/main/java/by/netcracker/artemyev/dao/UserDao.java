package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.entity.User;
import by.netcracker.artemyev.exception.DaoException;

public interface UserDao extends GeneralDao<User> {
    void add(User object) throws DaoException;
    void update(User object) throws DaoException;
    void remove(User object) throws DaoException;
    User getById(int id) throws DaoException;
}
