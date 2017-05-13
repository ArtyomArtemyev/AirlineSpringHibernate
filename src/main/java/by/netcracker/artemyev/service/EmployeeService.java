package by.netcracker.artemyev.service;

import by.netcracker.artemyev.entity.impl.Employee;
import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

/**
 * @autor Artemyev Artoym
 */
public interface EmployeeService extends GeneralService<Employee> {
    void add(Employee object) throws ServiceException;
    void update(Employee object) throws ServiceException;
    void remove(Employee object) throws ServiceException;
    Employee getById(int id) throws ServiceException;
    List<Employee> getAll() throws ServiceException;
}
