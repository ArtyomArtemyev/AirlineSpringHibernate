package by.netcracker.artemyev.service;

import by.netcracker.artemyev.constant.LoggingName;
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

    /**
     * Creates the given entity
     *
     * @param object - entity to be created
     * @throws ServiceException - if something fails at service layer
     */
    @Transactional
    @Override
    public void add(T object) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_ADD_ENTITY);
        try {
           dao.add(object);
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * Updates the given entity
     *
     * @param object - entity to be updated
     * @throws ServiceException - if something fails at service layer
     */
    @Transactional
    @Override
    public void update(T object) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_UPDATE_ENTITY);
        try {
            dao.update(object);
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * Deletes the given entity
     *
     * @param object - entity to be deleted
     * @throws ServiceException - if something fails at service layer
     */
    @Transactional
    @Override
    public void remove(T object) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_REMOVE_ENTITY);
        try {
            dao.remove(object);
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * Returns entity by id
     *
     * @param id - id of the entities to be returned
     * @return - entity from the database
     * @throws ServiceException - if something fails at service layer
     */
    @Transactional(readOnly = true)
    @Override
    public T getById(Long id) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_GET_ENTITY_BY_ID);
        try {
            return dao.getById(id);
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * Returns all entities
     *
     * @return - a list with all entities from the database
     * @throws ServiceException - if something fails at service layer
     */
    @Transactional(readOnly = true)
    @Override
    public List<T> getAll() throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_GET_ALL_ENTITY);
        try {
            return dao.getAll();
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(e.getMessage());
        }
    }

}
