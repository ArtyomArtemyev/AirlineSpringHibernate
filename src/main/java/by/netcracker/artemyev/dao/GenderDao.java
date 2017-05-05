package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.ErrorMessage;
import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Gender;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenderDao extends GenericDao<Gender> {

    @Autowired
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
