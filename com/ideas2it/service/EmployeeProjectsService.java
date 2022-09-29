package com.ideas2it.service;

import com.ideas2it.model.EmployeeProjects;
import com.ideas2it.dao.EmployeeProjectsDao;
import com.ideas2it.dao.EmployeeProjectsDaoImpl;

import java.util.List;

public interface EmployeeProjectsService {
    /**
     * <p>
     * This method gets all the received inputted elements as a object
from the controller for the employee project creation
     * </p>
     *
     * @param employeeProject
     *        Details of an employee to be passed to the dao(i.e a new employee)
     *  
     * @return boolean element to confirm the record
is added succesfully in the database
     *                  
     */ 
    public boolean addEmployeeProject(EmployeeProjects record);


    /**
     * <p>
     * Gets leave records for an specific employee
     * </p>
     * @param employeeId
     *        contains an employee Id 
     * @return Details of projects of an employee
     *
     */
    public EmployeeProjects getEmployeeProject(String employeeId);

    /**
     * <p>
     * passes the updated details to the dao
     * </p>
     *
     * @param employee
     *        the updated elements of a employee Project
     * @return a false boolean value if the update
process is successfull
     */
    public boolean updateEmployeeProjects(EmployeeProjects employeeProjects);

}