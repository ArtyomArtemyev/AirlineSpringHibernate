package by.netcracker.artemyev.dao.impl;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.dao.GenericDao;
import by.netcracker.artemyev.dao.UserDao;
import by.netcracker.artemyev.entity.impl.User;
import by.netcracker.artemyev.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Class describes concrete implementation of the UserDao
 *
 * @autor Artemyev Artoym
 */
@Repository
public class UserDaoImpl extends GenericDao<User> implements UserDao {
    private static Logger logger = LogManager.getLogger(UserDaoImpl.class);
    private final static String USER_LOGIN = "login";
    private final static String USER_PASSWORD = "password";

    public UserDaoImpl() {
        super(User.class);
    }

    /**
     * Returns all users from database
     *
     * @return list with users from database
     * @throws DaoException If something fails at database layer
     */
    @Override
    public List<User> getAll() throws DaoException {
        logger.debug(LoggingName.DAO_FUNCTION_GET_ALL_USERS);
        List<User> userList;
        try {
            userList = getEntityManager().createQuery(Statement.GET_ALL_USERS).getResultList();
        } catch (HibernateException e) {
            logger.error(e);
            throw new DaoException(ErrorMessage.GET_ALL_ENTITY_FAIL, e);
        }
        return userList;
    }

    /**
     * Returns user from database by login and password
     *
     * @return list with user from database
     * @throws DaoException If something fails at database layer
     */
    public List<User> getByLoginAndPassword(String userLogin, String userPassword) throws DaoException {
        logger.debug(LoggingName.DAO_FUNCTION_GET_USER_BY_LOGIN_AND_PASSWORD);
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
            logger.error(e);
            throw new DaoException(ErrorMessage.GET_ENTITY_BY_LOGIN_AND_PASSWORD_FAIL, e);
        }
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

}
