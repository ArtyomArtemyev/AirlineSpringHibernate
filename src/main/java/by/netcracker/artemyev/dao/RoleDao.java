package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDao extends GenericDao<Role> {

    @Override
    public Role getById(int id) {
        return getEntityManager().find(Role.class, id);
    }

    @Override
    public List<Role> getAll() {
        List<Role> roleList = getEntityManager().createQuery(Statement.GET_ALL_ROLES).getResultList();
        return roleList;
    }

}
