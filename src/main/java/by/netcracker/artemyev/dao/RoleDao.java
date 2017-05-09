package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.entity.Role;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class describes dao for Role
 * @autor Artemyev Artoym
 */
@Repository
public class RoleDao extends GenericDao<Role> {

    private RoleDao() {
        super(Role.class);
    }

    @Override
    public List<Role> getAll() {
        List<Role> roleList;
        try {
            roleList = getEntityManager().createQuery(Statement.GET_ALL_ROLES).getResultList();
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.MESSAGE_GET_ALL_ENTITY_FAIL, e);
        }
        return roleList;
    }

}
