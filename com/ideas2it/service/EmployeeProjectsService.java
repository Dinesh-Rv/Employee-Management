package com.ideas2it.service;

import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeProjects;

import java.util.List;

public interface EmployeeProjectsService {
    /**
     * <p>
     * This method gets all the received inputted elements as a object
     * from the controller for the employee project creation
     * </p>
     *
     * @param record   Details of an employee to be passed to the dao(i.e a new employee)
     * @param employee Contains the object of the Employee
     *
     * @return boolean element to confirm the record
     * is added successful in the database
     */ 
    public boolean addEmployeeProject(EmployeeProjects record, Employee employee);


    /**
     * <p>
     * Gets leave records for an specific employee
     * </p>
     *
     * @param employeeId contains an employee Id
     * @return Details of projects of an employee
     */
    public List<EmployeeProjects> getEmployeeProject(String employeeId);

    /**
     * <p>
     * passes the updated details to the dao
     * </p>
     *
     * @param projects
     *        the updated elements of a employee Project
     * @return a false boolean value if the update
process is successfull
     */
    public boolean updateEmployeeProjects(EmployeeProjects projects);

}