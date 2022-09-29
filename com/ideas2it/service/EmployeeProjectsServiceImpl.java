package com.ideas2it.service;

import com.ideas2it.model.EmployeeProjects;
import com.ideas2it.dao.EmployeeProjectsDao;
import com.ideas2it.dao.EmployeeProjectsDaoImpl;

import java.util.List;

public class EmployeeProjectsServiceImpl implements EmployeeProjectsService {

    private EmployeeProjectsDao employeeProjectsDaoImpl = new EmployeeProjectsDaoImpl();

    public boolean addEmployeeProject(EmployeeProjects record) {
        return employeeProjectsDaoImpl.addEmployeeProject(record);
    }

    public EmployeeProjects getEmployeeProject(String employeeId) {
        return employeeProjectsDaoImpl.getEmployeeProject(employeeId);
    }

    public boolean updateEmployeeProjects(EmployeeProjects employeeProjects) {
         return employeeProjectsDaoImpl.updateEmployeeProjects(employeeProjects);
    }
}