package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.ErrorMessage;
import by.netcracker.artemyev.exception.DaoException;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Interface describes generic dao
 * @autor Artemyev Artoym
 */
public abstract class GenericDao<T> implements GeneralDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void add(T object) {
        try {
            getEntityManager().persist(object);
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.MESSAGE_ADD_ENTITY_FAIL, e);
        }
    }

    @Override
    public void update(T object) {
        try {
            getEntityManager().merge(object);
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.MESSAGE_UPDATE_ENTITY_FAIL, e);
        }
    }

    @Override
    public void remove(T object) {
        try {
            getEntityManager().remove(object);
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.MESSAGE_REMOVE_ENTITY_FAIL, e);
        }
    }

    public abstract T getById(int id) throws DaoException;

    public abstract List<T> getAll() throws DaoException;

}
