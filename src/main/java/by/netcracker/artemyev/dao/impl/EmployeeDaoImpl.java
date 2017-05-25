package by.netcracker.artemyev.dao.impl;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.dao.EmployeeDao;
import by.netcracker.artemyev.dao.GenericDao;
import by.netcracker.artemyev.entity.impl.Employee;
import by.netcracker.artemyev.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class describes dao for Employee
 * @autor Artemyev Artoym
 */
@Repository
public class EmployeeDaoImpl extends GenericDao<Employee> implements EmployeeDao {
    private static Logger logger = LogManager.getLogger(EmployeeDaoImpl.class.getName());

    private EmployeeDaoImpl() {
        super(Employee.class);
    }

    @Override
    public List<Employee> getAll() throws DaoException {
        logger.debug(LoggingName.DAO_FUNCTION_GET_ALL_EMPLOYEES);
        List<Employee> employeeList;
        try {
            employeeList = getEntityManager().createQuery(Statement.GET_ALL_EMPLOYEES).getResultList();
        } catch (HibernateException e) {
            logger.debug(e);
            throw new DaoException(ErrorMessage.GET_ALL_ENTITY_FAIL, e);
        }
        return employeeList;
    }

}