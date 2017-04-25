package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDao implements GeneralDao<User> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User object) {
        entityManager.persist(object);
    }

    @Override
    public void update(User object) {
        entityManager.merge(object);
    }

    @Override
    public void remove(User object) {
        entityManager.remove(object);
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        List<User> userList = entityManager.createQuery(Statement.GET_ALL_USERS).getResultList();
        return userList;
    }

}
