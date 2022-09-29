package com.ideas2it.dao;
import com.ideas2it.model.EmployeeProjects;
import java.util.List;

/**
 * LeaveRecordsDao.java
 *
 * Interface that acts as a data access for the employee Projects
 *
 * @author Dinesh Ravikumar
 * @modified at 19-09-2022
 */
public interface EmployeeProjectsDao {

    /**
     * <p>
     * Gets all the received details and adds it to the database
     * </p>
     *
     * @param record
     *        contains the details of a record to be inserted to the row  
     * @return number of employees added in database (i.e number of tables affected)                
     */
    public boolean addEmployeeProject(EmployeeProjects record);

    /**
     * <p>
     * Gets all the projects of a single employee, as if for now
employee has one to many relationship with project so it isn't usefull for
now but in the future.
     * </p>
     *
     * @return the details of a employee                  
     */
    public EmployeeProjects getEmployeeProject(String employeeId);
     
    /**
     * <p>
     * Updates the project details of an employee
     * </p>
     *
     * @return boolean value to ensure update process                
     */
    public boolean updateEmployeeProjects(EmployeeProjects employeeProjects);
}