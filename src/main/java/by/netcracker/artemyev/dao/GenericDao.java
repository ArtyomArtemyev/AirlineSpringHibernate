package by.netcracker.artemyev.dao;

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
        getEntityManager().persist(object);
    }

    @Override
    public void update(T object) {
        getEntityManager().merge(object);
    }

    @Override
    public void remove(T object) {
        getEntityManager().remove(object);
    }

    public abstract T getById(int id);

    public abstract List<T> getAll();

}
