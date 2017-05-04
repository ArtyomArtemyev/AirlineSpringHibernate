package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.EmployeeDao;
import by.netcracker.artemyev.entity.Employee;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employeeService")
public class EmployeeService implements GeneralService<Employee> {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    @Override
    public void add(Employee object) throws ServiceException {
        try {
            employeeDao.add(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void update(Employee object) throws ServiceException {
        try {
            employeeDao.update(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void remove(Employee object) throws ServiceException {
        try {
            employeeDao.remove(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Employee getById(int id) throws ServiceException {
        try {
            return employeeDao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> getAll() throws ServiceException {
        try {
            return employeeDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
