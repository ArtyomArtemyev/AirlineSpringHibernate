package by.netcracker.artemyev.dao.impl;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.dao.GenericDao;
import by.netcracker.artemyev.dao.RoleDao;
import by.netcracker.artemyev.entity.impl.Role;
import by.netcracker.artemyev.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class describes dao for Role
 * @autor Artemyev Artoym
 */
@Repository
public class RoleDaoImpl extends GenericDao<Role> implements RoleDao {
    private static Logger logger = LogManager.getLogger(RoleDaoImpl.class.getName());

    private RoleDaoImpl() {
        super(Role.class);
    }

    @Override
    public List<Role> getAll() {
        logger.debug(LoggingName.DAO_FUNCTION_GET_ALL_ROLES);
        List<Role> roleList;
        try {
            roleList = getEntityManager().createQuery(Statement.GET_ALL_ROLES).getResultList();
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.GET_ALL_ENTITY_FAIL, e);
        }
        return roleList;
    }

}
