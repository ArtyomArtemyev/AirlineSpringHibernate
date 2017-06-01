package by.netcracker.artemyev.service;

import by.netcracker.artemyev.entity.impl.User;
import by.netcracker.artemyev.exception.ServiceException;

/**
 * @autor Artemyev Artoym
 */
public interface UserService extends GeneralService<User> {
    String checkUser(String userLogin, String userPassword) throws ServiceException;
    void createUser(String userLogin, String userPassword, String userMail) throws ServiceException;
    Long getByLoginAndPassword(String userLogin, String userPassword) throws ServiceException;
}
