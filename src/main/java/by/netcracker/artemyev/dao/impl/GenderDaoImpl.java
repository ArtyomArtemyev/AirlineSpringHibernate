package by.netcracker.artemyev.dao.impl;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.dao.GenderDao;
import by.netcracker.artemyev.dao.GenericDao;
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
public class GenderDaoImpl extends GenericDao<Gender> implements GenderDao {

    private GenderDaoImpl() {
        super(Gender.class);
    }

    @Override
    public List<Gender> getAll() {
        List<Gender> genderList;
        try {
            genderList = getEntityManager().createQuery(Statement.GET_ALL_GENDERS).getResultList();
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.GET_ALL_ENTITY_FAIL, e);
        }
        return genderList;
    }

}
