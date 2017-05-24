package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.GenericDao;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @autor Artemyev Artoym
 */
@Service
public abstract class GenericService<T> implements GeneralService<T> {
    private static Logger logger = LogManager.getLogger(GenericService.class);

    @Autowired
    private GenericDao<T> dao;

    public GenericService() {
        super();
    }

    public GenericService(GenericDao<T> dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public void add(T object) throws ServiceException {
        try {
           dao.add(object);
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void update(T object) throws ServiceException {
        try {
            dao.update(object);
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void remove(T object) throws ServiceException {
        try {
            dao.remove(object);
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public T getById(Long id) throws ServiceException {
        try {
            return dao.getById(id);
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> getAll() throws ServiceException {
        try {
            return dao.getAll();
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
    }

}
