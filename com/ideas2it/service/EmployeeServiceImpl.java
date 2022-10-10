package com.ideas2it.service;

import com.ideas2it.service.EmployeeService;
import com.ideas2it.model.Employee;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dao.EmployeeDaoImpl;
import com.ideas2it.service.LeaveRecordsService;
import com.ideas2it.service.LeaveRecordsServiceImpl;
import com.ideas2it.service.EmployeeProjectsServiceImpl;

import java.util.List;
import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService {	

    EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();
    LeaveRecordsService leaveRecordServiceImpl = new LeaveRecordsServiceImpl();
    
    public String addEmployee(Employee employee) {
        return employeeDaoImpl.insertEmployee(employee);
    }
    
    public List<Employee> getEmployees() {
        return employeeDaoImpl.getEmployees();
    }

     public boolean updateEmployee(Employee employee) {
         return employeeDaoImpl.updateEmployee(employee);
    }

    public int removeEmployee(Employee employee) {
         leaveRecordServiceImpl.removeEmployeeLeaveRecords(employee);
         System.out.println("After remove rec");
         //employeeProjectsImpl.removeAllEmployeeProjects(employee);
	 //int removeEmployeeRecord = employeeDaoImpl.removeEmployee(employee.getEmployeeId());
         
         return 1; //removeEmployeeRecord;
    }

    public Employee getEmployeeById(String employeeId) {
        return employeeDaoImpl.getEmployeeById(employeeId);
    }

    public String getEmployeeId() {
        return employeeDaoImpl.getEmployeeId();
    }
}