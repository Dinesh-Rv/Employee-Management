package com.ideas2it.service;

import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeProjects;
import com.ideas2it.dao.EmployeeProjectsDao;
import com.ideas2it.dao.EmployeeProjectsDaoImpl;

import java.util.List;

public class EmployeeProjectsServiceImpl implements EmployeeProjectsService {

    private EmployeeProjectsDao employeeProjectsDaoImpl = new EmployeeProjectsDaoImpl();

    public boolean addEmployeeProject(EmployeeProjects record, Employee employee) {
        return employeeProjectsDaoImpl.addEmployeeProject(record, employee);
    }

    public List<EmployeeProjects> getEmployeeProject(String employeeId) {
        return employeeProjectsDaoImpl.getEmployeeProject(employeeId);
    }

    public boolean updateEmployeeProjects(EmployeeProjects projects) {
         return employeeProjectsDaoImpl.updateEmployeeProjects(projects);
    }
}