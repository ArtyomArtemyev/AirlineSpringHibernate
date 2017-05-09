package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.entity.Gender;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class describes dao for Gender
 * @autor Artemyev Artoym
 */
@Repository
public class GenderDao extends GenericDao<Gender> {

    private GenderDao() {
        super(Gender.class);
    }

    @Override
    public List<Gender> getAll() {
        List<Gender> genderList;
        try {
            genderList = getEntityManager().createQuery(Statement.GET_ALL_GENDERS).getResultList();
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.MESSAGE_GET_ALL_ENTITY_FAIL, e);
        }
        return genderList;
    }

}
