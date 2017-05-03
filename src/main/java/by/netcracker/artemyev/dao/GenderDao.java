package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Gender;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenderDao extends GenericDao<Gender> {

    @Override
    public Gender getById(int id) {
        return getEntityManager().find(Gender.class, id);
    }

    @Override
    public List<Gender> getAll() {
        List<Gender> genderList = getEntityManager().createQuery(Statement.GET_ALL_GENDERS).getResultList();
        return genderList;
    }

}
