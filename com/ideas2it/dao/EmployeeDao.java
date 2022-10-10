package com.ideas2it.dao;
import com.ideas2it.model.Employee;

import java.util.List;

/**
 * EmployeeDao.java
 * <p>
 * Interface that acts as a data access for the Employee Crud operations
 * </p>
 * @author Dinesh Ravikumar
 * @modified 21-09-2022
 */
public interface EmployeeDao {
    
    /**
     * <p>
     * Gets all the received details and adds it to the database
     * </p>
     *
     * @param employee
     *        contains the details of a new employee to add     
     * @return is the addition of the employee is successfull
     *         true if the employee is added successfully              
     */
    public String insertEmployee(Employee employee);

    /**
     * <p>
     * Gets all the employee details
     * </p>
     *
     * @return the details of all employees                    
     */
    public List<Employee> getEmployees();

    /**
     * <p>
     * Gets the updated employee details and passes it to the database,
     * </p>
     *
     * @return the details of all trainees                    
     */
    public boolean updateEmployee(Employee employee);

    /**
     * <p>
     * Deletes an employee
     * </p>
     *
     * @return boolean, true if the delete process is successfull                   
     */
    public int removeEmployee(String employeeId);

    /**
     * <p>
     * Gets the details of a single employee 
     * </p>
     *
     * @return the details of a employee                  
     */
    public Employee getEmployeeById(String employeeId);

    /**
     * <p>
     * Gets the last employee id in the database 
     * </p>
     *
     * @return the last id created
     */
    public String getEmployeeId();
}