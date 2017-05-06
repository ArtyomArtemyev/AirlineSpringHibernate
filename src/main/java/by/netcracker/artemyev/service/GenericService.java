package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.GenericDao;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenericService<T> implements GeneralService<T> {

    @Autowired
    private GenericDao<T> genericDao;

    @Transactional
    @Override
    public void add(T object) throws ServiceException {
        try {
            genericDao.add(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void update(T object) throws ServiceException {
        try {
            genericDao.update(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void remove(T object) throws ServiceException {
        try {
            genericDao.remove(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public T getById(int id) throws ServiceException {
        try {
            return genericDao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> getAll() throws ServiceException {
        try {
            return genericDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
