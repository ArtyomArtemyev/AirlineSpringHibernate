package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.GenderDao;
import by.netcracker.artemyev.entity.Gender;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("genderService")
public class GenderService implements GeneralService<Gender> {

    @Autowired
    private GenderDao genderDao;

    @Transactional
    @Override
    public void add(Gender object) throws ServiceException {
        try {
            genderDao.add(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void update(Gender object) throws ServiceException {
        try {
            genderDao.update(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void remove(Gender object) throws ServiceException {
        try {
            genderDao.remove(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Gender getById(int id) throws ServiceException {
        try {
            return genderDao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Gender> getAll() throws ServiceException {
        try {
            return genderDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
