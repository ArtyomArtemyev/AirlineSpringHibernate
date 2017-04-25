package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.GenderDao;
import by.netcracker.artemyev.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("GenderService")
public class GenderService implements GeneralService<Gender> {

    @Autowired
    private GenderDao genderDao;

    @Transactional
    @Override
    public void add(Gender object) {
        genderDao.add(object);
    }

    @Transactional
    @Override
    public void update(Gender object) {
        genderDao.update(object);
    }

    @Transactional
    @Override
    public void remove(Gender object) {
        genderDao.remove(object);
    }

    @Transactional
    @Override
    public Gender getById(int id) {
       return genderDao.getById(id);
    }

    @Transactional
    @Override
    public List<Gender> getAll() {
        return genderDao.getAll();
    }

}
