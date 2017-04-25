package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDao implements GeneralDao<Employee> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Employee object) {
        entityManager.persist(object);
    }

    @Override
    public void update(Employee object) { entityManager.merge(object); }

    @Override
    public void remove(Employee object) { entityManager.remove(object); }

    @Override
    public Employee getById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = entityManager.createQuery(Statement.GET_ALL_EMPLOYEES).getResultList();
        return employeeList;
    }

}