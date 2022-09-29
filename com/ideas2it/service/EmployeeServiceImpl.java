package com.ideas2it.service;

import com.ideas2it.service.EmployeeService;
import com.ideas2it.model.Employee;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dao.EmployeeDaoImpl;

import java.util.List;
import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService {	

    EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();
    
    public String addEmployee(Employee employee) {
        return employeeDaoImpl.insertEmployee(employee);
    }
    
    public List<Employee> getEmployees() {
        return employeeDaoImpl.getEmployees();
    }

     public boolean updateEmployee(Employee employee) {
         return employeeDaoImpl.updateEmployee(employee);
    }

    public int deleteEmployee(String employeeId) {
	 return employeeDaoImpl.removeEmployee(employeeId);
    }

    public Employee getEmployeeById(String employeeId) {
        return employeeDaoImpl.getEmployeeById(employeeId);
    }

    public String getEmployeeId() {
        return employeeDaoImpl.getEmployeeId();
    }
}