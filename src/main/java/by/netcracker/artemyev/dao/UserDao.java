package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends GenericDao<User> {

    @Override
    public User getById(int id) {
        return getEntityManager().find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        List<User> userList = getEntityManager().createQuery(Statement.GET_ALL_USERS).getResultList();
        return userList;
    }

}
