package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Class describes common dao
 *
 * @autor Artemyev Artoym
 */
@Repository
public abstract class GenericDao<T> implements GeneralDao<T> {
    private static Logger logger = LogManager.getLogger(GenericDao.class);

    private Class<T> className;

    public GenericDao(Class<T> className) {
        this.className = className;
    }


    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Create the given entity in the database
     *
     * @param object - entity to be created
     * @throws DaoException If something fails at database level
     */
    @Override
    public void add(T object) throws DaoException {
        logger.debug(LoggingName.DAO_FUNCTION_ADD_ENTITY);
        try {
            getEntityManager().persist(object);
        } catch (HibernateException e) {
            logger.error(e);
            throw new DaoException(ErrorMessage.ADD_ENTITY_FAIL, e);
        }
    }

    /**
     * Update the given entity in the database
     *
     * @param object - entity to be updated
     * @throws DaoException If something fails at database level
     */
    @Override
    public void update(T object) throws DaoException {
        logger.debug(LoggingName.DAO_FUNCTION_UPDATE_ENTITY);
        try {
            getEntityManager().merge(object);
        } catch (HibernateException e) {
            logger.error(e);
            throw new DaoException(ErrorMessage.UPDATE_ENTITY_FAIL, e);
        }
    }

    /**
     * Delete the given entity in the database
     *
     * @param object - entity to be deleted
     * @throws DaoException If something fails at database level
     */
    @Override
    public void remove(T object) throws DaoException {
        logger.debug(LoggingName.DAO_FUNCTION_REMOVE_ENTITY);
        try {
            getEntityManager().remove(object);
        } catch (HibernateException e) {
            logger.error(e);
            throw new DaoException(ErrorMessage.REMOVE_ENTITY_FAIL, e);
        }
    }

    /**
     * Returns entity from the database matching the given ID
     *
     * @param id - The id of the entities to be returned
     * @return - the entities from the database
     * @throws DaoException If something fails at database level
     */
    @Override
    public T getById(Long id) throws DaoException {
        logger.debug(LoggingName.DAO_FUNCTION_GET_ENTITY_BY_ID);
        try {
            return getEntityManager().find(this.className, id);
        } catch (HibernateException e) {
            logger.error(e);
            throw new DaoException(ErrorMessage.GET_BY_ID_ENTITY_FAIL, e);
        }
    }

    /**
     * Returns a list with all entities from the database
     *
     * @return - a list of all entities from the database
     * @throws DaoException If something fails at database level
     */
    public abstract List<T> getAll() throws DaoException;

}
