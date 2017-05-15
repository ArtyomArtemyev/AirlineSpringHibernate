package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.exception.DaoException;
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
        try {
            getEntityManager().persist(object);
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.ADD_ENTITY_FAIL, e);
        }
    }

    @Override
    public void update(T object) {
        try {
            getEntityManager().merge(object);
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.UPDATE_ENTITY_FAIL, e);
        }
    }

    @Override
    public void remove(T object) {
        try {
            getEntityManager().remove(object);
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.REMOVE_ENTITY_FAIL, e);
        }
    }

    @Override
    public T getById(Long id) {
        try {
            return getEntityManager().find(this.className, id);
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.GET_BY_ID_ENTITY_FAIL, e);
        }
    }

    public abstract List<T> getAll() throws DaoException;

}
