package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.ErrorMessage;
import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.User;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class describes dao for User
 * @autor Artemyev Artoym
 */
@Repository
public class UserDao extends GenericDao<User> {

    @Autowired
    private UserDao() {
        super(User.class);
    }

    @Override
    public List<User> getAll() {
        List<User> userList;
        try {
            userList = getEntityManager().createQuery(Statement.GET_ALL_USERS).getResultList();
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.MESSAGE_GET_ALL_ENTITY_FAIL, e);
        }
        return userList;
    }

}
