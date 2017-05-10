package by.netcracker.artemyev.dao.impl;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.dao.EmployeeDao;
import by.netcracker.artemyev.dao.GenericDao;
import by.netcracker.artemyev.entity.impl.Employee;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class describes dao for Employee
 * @autor Artemyev Artoym
 */
@Repository
public class EmployeeDaoImpl extends GenericDao<Employee> implements EmployeeDao{

    private EmployeeDaoImpl() {
        super(Employee.class);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList;
        try {
            employeeList = getEntityManager().createQuery(Statement.GET_ALL_EMPLOYEES).getResultList();
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.GET_ALL_ENTITY_FAIL, e);
        }
        return employeeList;
    }

}