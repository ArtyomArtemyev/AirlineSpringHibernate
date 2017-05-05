package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.ErrorMessage;
import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Employee;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao extends GenericDao<Employee> {

    @Autowired
    private EmployeeDao() {
        super(Employee.class);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList;
        try {
            employeeList = getEntityManager().createQuery(Statement.GET_ALL_EMPLOYEES).getResultList();
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.MESSAGE_GET_ALL_ENTITY_FAIL, e);
        }
        return employeeList;
    }

}