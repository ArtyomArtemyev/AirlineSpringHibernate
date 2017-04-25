package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.UserDao;
import by.netcracker.artemyev.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserService")
public class UserService implements GeneralService<User> {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User object) {
        userDao.add(object);
    }

    @Transactional
    @Override
    public void update(User object) {
        userDao.update(object);
    }

    @Transactional
    @Override
    public void remove(User object) {
        userDao.update(object);
    }

    @Transactional
    @Override
    public User getById(int id) {
       return userDao.getById(id);
    }

    @Transactional
    @Override
    public List<User> getAll() {
       return userDao.getAll();
    }

}
