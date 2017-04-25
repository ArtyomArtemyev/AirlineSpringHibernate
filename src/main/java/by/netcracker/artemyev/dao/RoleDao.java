package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDao implements GeneralDao<Role> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Role object) {
        entityManager.persist(object);
    }

    @Override
    public void update(Role object) { entityManager.merge(object); }

    @Override
    public void remove(Role object) { entityManager.remove(object); }

    @Override
    public Role getById(int id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> getAll() {
        List<Role> roleList = entityManager.createQuery(Statement.GET_ALL_ROLES).getResultList();
        return roleList;
    }

}
