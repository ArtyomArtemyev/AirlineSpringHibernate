package by.netcracker.artemyev.service;

import by.netcracker.artemyev.entity.User;
import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

public interface UserService extends GeneralService<User> {
    void add(User object) throws ServiceException;
    void update(User object) throws ServiceException;
    void remove(User object) throws ServiceException;
    User getById(int id) throws ServiceException;
    List<User> getAll() throws ServiceException;
    String checkUser(String userLogin, String userPassword) throws ServiceException;
    public void addUser(String userLogin, String userPassword, String userMail) throws ServiceException;
}
