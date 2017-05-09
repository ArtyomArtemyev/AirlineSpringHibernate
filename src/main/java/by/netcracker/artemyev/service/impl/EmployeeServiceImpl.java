package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.dao.EmployeeDao;
import by.netcracker.artemyev.entity.Employee;
import by.netcracker.artemyev.service.EmployeeService;
import by.netcracker.artemyev.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends GenericService<Employee> implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

}
