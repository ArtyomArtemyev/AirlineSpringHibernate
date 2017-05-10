package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.entity.impl.Employee;
import by.netcracker.artemyev.exception.DaoException;

public interface EmployeeDao extends GeneralDao<Employee> {
    void add(Employee object) throws DaoException;
    void update(Employee object) throws DaoException;
    void remove(Employee object) throws DaoException;
    Employee getById(int id) throws DaoException;
}
