package com.ideas2it.dao;
import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeProjects;

import java.util.List;

/**
 * LeaveRecordsDao.java
 * <p>
 * Interface that acts as a data access for the employee Projects
 * </p>
 * @author Dinesh Ravikumar
 * @modified at 10-10-2022
 */
public interface EmployeeProjectsDao {

    /**
     * <p>
     * Gets all the received details and adds it to the database
     * </p>
     *
     * @param record
     *        contains the details of a record to be inserted to the row
     * @param employee
     *        contains the object of an employee
     * @return boolean result
     *         true if the project addition is successful
     */
    public boolean addEmployeeProject(EmployeeProjects record, Employee employee);

    /**
     * <p>
     * Gets all the projects of a single employee, and passes it to service
     * for displaying those details
     * </p>
     *
     * @param employeeId contains an id of an employee
     * @return the details of a employee
     */
    public List<EmployeeProjects> getEmployeeProject(String employeeId);
     
    /**
     * <p>
     * Updates the project details of an employee
     * </p>
     * @param projects
     *        contains an project obiject to be edited
     * @return boolean value to ensure update process                
     */
    public boolean updateEmployeeProjects(EmployeeProjects projects);
}