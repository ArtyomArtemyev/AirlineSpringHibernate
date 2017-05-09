package by.netcracker.artemyev.dao.impl;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.dao.GenericDao;
import by.netcracker.artemyev.dao.UserDao;
import by.netcracker.artemyev.entity.User;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Class describes dao for User
 * @autor Artemyev Artoym
 */
@Repository
public class UserDaoImpl extends GenericDao<User> implements UserDao {
    private final static String USER_LOGIN = "login";
    private final static String USER_PASSWORD = "password";

    private UserDaoImpl() {
        super(User.class);
    }

    @Override
    public List<User> getAll() {
        List<User> userList;
        try {
            userList = getEntityManager().createQuery(Statement.GET_ALL_USERS).getResultList();
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.GET_ALL_ENTITY_FAIL, e);
        }
        return userList;
    }

    public List<User> getByLoginAndPassword(String userLogin, String userPassword) {
        CriteriaQuery<User> criteriaQuery;
        try {
            CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
            criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> userRoot = criteriaQuery.from(User.class);
            criteriaQuery.select(userRoot);
            criteriaQuery.where(
                    criteriaBuilder.equal(userRoot.get(USER_LOGIN), userLogin),
                    criteriaBuilder.equal(userRoot.get(USER_PASSWORD), userPassword)
            );
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.GET_ENTITY_BY_LOGIN_AND_PASSWORD_FAIL, e);
        }
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

}
