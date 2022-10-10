package com.ideas2it.model;
import com.ideas2it.enums.LeaveType;
import com.ideas2it.model.Employee;

/**
 * <p> Contains every attribute for leave records for
an employee, doesn't contain any i/o operation
 * </p>
 *
 */
public class LeaveRecords {
   
    private int leaveRecordId;
    private Employee employee;
    private String fromDate;
    private String toDate;
    private String leaveType;
    private String createdAt;
    private String modifiedAt;

    private int deleted;

    public LeaveRecords() {
    }

    public LeaveRecords(Employee employee,
                        String fromDate, 
                        String toDate,
                        String leaveType,
                        String createdAt,
                        String modifiedAt) {
        this.employee = employee;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.leaveType = leaveType;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public LeaveRecords(int leaveRecordId,
                        Employee employee, 
                        String fromDate, 
                        String toDate,
                        String leaveType) {
        this.leaveRecordId = leaveRecordId;
        this.employee = employee;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.leaveType = leaveType;
    }

    public void setLeaveRecordId(int leaveRecordId) {
        this.leaveRecordId = leaveRecordId;
    }

    public int getLeaveRecordId() {		
        return leaveRecordId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {		
        return employee;
    } 

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
	
    public String getFromDate() {
        return fromDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }	

    public String getToDate() {
        return toDate;
    }
 
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveType() {		
        return leaveType;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }


    public int getDeleted() {
        return deleted;
    }

    @Override
    public String toString() {
        return "\nLeave Reference Id :" + leaveRecordId 
             + "\nLeave Type : " + leaveType 
             + "\nFrom :" + fromDate 
             + "\nTo : "+ toDate + "\n";
    }	
}