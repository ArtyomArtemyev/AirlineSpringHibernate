package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.entity.impl.User;
import by.netcracker.artemyev.exception.DaoException;

import java.util.List;

/**
 * Interface describes dao layer for entity User
 *
 * @autor Artemyev Artoym
 */
public interface UserDao extends GeneralDao<User> {
    List<User> getByLoginAndPassword(String userLogin, String userPassword) throws DaoException;
}
