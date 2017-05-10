package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.entity.impl.User;
import by.netcracker.artemyev.exception.DaoException;

import java.util.List;

public interface UserDao extends GeneralDao<User> {
    void add(User object) throws DaoException;
    void update(User object) throws DaoException;
    void remove(User object) throws DaoException;
    User getById(int id) throws DaoException;
    List<User> getByLoginAndPassword(String userLogin, String userPassword) throws DaoException;
}
