package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.RoleDao;
import by.netcracker.artemyev.entity.Role;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
public class RoleService implements GeneralService<Role>{

    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public void add(Role object)  throws ServiceException {
        try {
            roleDao.add(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void update(Role object) throws ServiceException {
        try {
            roleDao.update(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void remove(Role object) throws ServiceException {
        try {
            roleDao.remove(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Role getById(int id) throws ServiceException {
        try {
            return roleDao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getAll() throws ServiceException {
        try {
            return roleDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
