package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.ErrorMessage;
import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.User;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends GenericDao<User> {

    @Override
    public User getById(int id) {
        try {
            return getEntityManager().find(User.class, id);
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.MESSAGE_GET_BY_ID_ENTITY_FAIL, e);
        }
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
