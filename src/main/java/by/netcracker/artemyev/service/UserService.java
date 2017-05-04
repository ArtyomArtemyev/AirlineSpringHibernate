package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.UserDao;
import by.netcracker.artemyev.entity.User;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserService implements GeneralService<User> {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User object) throws ServiceException {
        try {
            userDao.add(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void update(User object) throws ServiceException {
        try {
            userDao.update(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void remove(User object) throws ServiceException {
        try {
            userDao.update(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public User getById(int id) throws ServiceException {
        try {
            return userDao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAll() throws ServiceException {
        try {
            return userDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
