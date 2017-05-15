package by.netcracker.artemyev.service;

import by.netcracker.artemyev.entity.impl.User;
import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

/**
 * @autor Artemyev Artoym
 */
public interface UserService extends GeneralService<User> {
    void add(User object) throws ServiceException;
    void update(User object) throws ServiceException;
    void remove(User object) throws ServiceException;
    User getById(Long id) throws ServiceException;
    List<User> getAll() throws ServiceException;
    String checkUser(String userLogin, String userPassword) throws ServiceException;
    void addUser(String userLogin, String userPassword, String userMail) throws ServiceException;
}
