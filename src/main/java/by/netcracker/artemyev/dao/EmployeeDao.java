package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao extends GenericDao<Employee> {

    @Override
    public Employee getById(int id) {
        return getEntityManager().find(Employee.class, id);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = getEntityManager().createQuery(Statement.GET_ALL_EMPLOYEES).getResultList();
        return employeeList;
    }

}