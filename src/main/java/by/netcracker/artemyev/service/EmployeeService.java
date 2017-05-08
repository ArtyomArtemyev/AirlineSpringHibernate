package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.EmployeeDao;
import by.netcracker.artemyev.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeService extends GenericService<Employee> {

    @Autowired
    private EmployeeDao employeeDao;

}
