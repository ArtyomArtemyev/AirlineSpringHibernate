package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.EmployeeDao;
import by.netcracker.artemyev.entity.Employee;
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
    public void add(Employee object) {
        employeeDao.add(object);
    }

    @Transactional
    @Override
    public void update(Employee object) {
        employeeDao.update(object);
    }

    @Transactional
    @Override
    public void remove(Employee object) {
        employeeDao.remove(object);
    }

    @Transactional(readOnly = true)
    @Override
    public Employee getById(int id) {
        return employeeDao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

}
