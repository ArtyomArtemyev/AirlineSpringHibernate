package by.netcracker.artemyev.dao.impl;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.dao.GenderDao;
import by.netcracker.artemyev.dao.GenericDao;
import by.netcracker.artemyev.entity.impl.Gender;
import by.netcracker.artemyev.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class describes concrete implementation of the GenderDao
 *
 * @autor Artemyev Artoym
 */
@Repository
public class GenderDaoImpl extends GenericDao<Gender> implements GenderDao {
    private static Logger logger = LogManager.getLogger(GenderDaoImpl.class);

    private GenderDaoImpl() {
        super(Gender.class);
    }

    /**
     * Returns all genders from database
     *
     * @return list with genders from database
     * @throws DaoException If something fails at database layer
     */
    @Override
    public List<Gender> getAll() throws DaoException {
        logger.debug(LoggingName.DAO_FUNCTION_GET_ALL_GENDERS);
        List<Gender> genderList;
        try {
            genderList = getEntityManager().createQuery(Statement.GET_ALL_GENDERS).getResultList();
        } catch (HibernateException e) {
            logger.error(e);
            throw new DaoException(ErrorMessage.GET_ALL_ENTITY_FAIL, e);
        }
        return genderList;
    }

}
