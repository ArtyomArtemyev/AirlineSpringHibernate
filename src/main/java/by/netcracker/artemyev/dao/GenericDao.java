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

    @Override
    public void add(T object) {
        logger.debug(LoggingName.DAO_FUNCTION_ADD_ENTITY);
        try {
            getEntityManager().persist(object);
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.ADD_ENTITY_FAIL, e);
        }
    }

    @Override
    public void update(T object) {
        logger.debug(LoggingName.DAO_FUNCTION_UPDATE_ENTITY);
        try {
            getEntityManager().merge(object);
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.UPDATE_ENTITY_FAIL, e);
        }
    }

    @Override
    public void remove(T object) {
        logger.debug(LoggingName.DAO_FUNCTION_REMOVE_ENTITY);
        try {
            getEntityManager().remove(object);
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.REMOVE_ENTITY_FAIL, e);
        }
    }

    @Override
    public T getById(Long id) {
        logger.debug(LoggingName.DAO_FUNCTION_GET_ENTITY_BY_ID);
        try {
            return getEntityManager().find(this.className, id);
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.GET_BY_ID_ENTITY_FAIL, e);
        }
    }

    public abstract List<T> getAll() throws DaoException;

}
