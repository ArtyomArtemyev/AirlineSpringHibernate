package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Gender;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GenderDao implements GeneralDao<Gender> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Gender object) {
        entityManager.persist(object);
    }

    @Override
    public void update(Gender object) { entityManager.merge(object); }

    @Override
    public void remove(Gender object) { entityManager.remove(object); }

    @Override
    public Gender getById(int id) {
        return entityManager.find(Gender.class, id);
    }

    @Override
    public List<Gender> getAll() {
        List<Gender> genderList = entityManager.createQuery(Statement.GET_ALL_GENDERS).getResultList();
        return genderList;
    }

}
