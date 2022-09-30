package com.ideas2it.dao;
import com.ideas2it.model.LeaveRecords;
import com.ideas2it.model.Employee;

import java.util.List;

/**
 * LeaveRecordsDao.java
 * 
 * Interface that acts as a data access for the Leave Records for the employee
 *
 * @author Dinesh Ravikumar
 * @modified at 19-09-2022
 */
public interface LeaveRecordsDao {

    /**
     * <p>
     * Gets all the received details and adds it to the database
     * </p>
     *
     * @param record
     *        contains the details of a record to be inserted to the row  
     * @return number of employees added in database (i.e number of tables affected)                
     */
    public int addLeaveRecord(LeaveRecords record);

    /**
     * <p>
     * Gets all the leave records of a single employee 
     * </p>
     *
     * @return the details of a employee                  
     */
    public List<LeaveRecords> getLeaveRecords(String employeeId);

    /**
     * <p>
     * Gets the leave records and passes it to the database,
     * </p>
     *
     * @return the details of all trainees                    
     */
    public boolean updateLeaveRecords(LeaveRecords leaveRecords);

    /**
     * <p>
     * Gets the leave record using corresponding inputs,
     * </p>
     *
     * @return the details of all trainees                    
     */
    public LeaveRecords getLeaveRecord(String employeeId, int userLeaveRecordId);

}
