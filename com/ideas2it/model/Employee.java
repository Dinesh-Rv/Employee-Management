package com.ideas2it.model;
import com.ideas2it.enums.EmployeeRole;
import com.ideas2it.enums.EmployeeGender;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

/**
 * </p> Contains every attribute common for all employee, doesn't contain
 * any input or output operations
 * <p>
 *
 */
public class Employee {
   
    private String employeeName;
    private String employeeDepartment;
    private String employeePhoneNumber;
    private String employeeDateOfBirth;
    private String employeeEmail;
    private int employeeAge;
    private String employeeId;
    private String employeeRole;
    private String employeeGender;
    private String createdAt;
    private String modifiedAt;
    private List leaveRecords;

    public Employee () {
    }
  

    public Employee(String employeeName, 
                    String employeeRole,
                    String employeeDepartment, 
                    String employeePhoneNumber,
                    String employeeDateOfBirth,
                    String employeeGender,
                    String employeeEmail,
                    String employeeId,
                    String createdAt,
                    String modifiedAt) {
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeEmail = employeeEmail;
        this.employeeId = employeeId;
        this.employeeRole = employeeRole;
        this.employeeGender = employeeGender;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Employee(String employeeName, 
                    String employeeRole,
                    String employeeDepartment, 
                    String employeePhoneNumber,
                    String employeeDateOfBirth,
                    String employeeGender,
                    String employeeEmail,
                    String employeeId) {
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeEmail = employeeEmail;
        this.employeeId = employeeId;
        this.employeeRole = employeeRole;
        this.employeeGender = employeeGender;
        setEmployeeAge(employeeDateOfBirth);
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {		
        return employeeName;
    } 

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeDepartment() {		
	return employeeDepartment;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }
	
    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }	

    public String getEmployeeId() {
        return  employeeId;
    }
 
    public void setEmployeeDateOfBirth(String employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
        setEmployeeAge(employeeDateOfBirth);	
    }

    public String getEmployeeDateOfBirth() {	
        return employeeDateOfBirth;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }  

    public String getEmployeeEmail() {		
        return employeeEmail;
    }  

    public void setEmployeeAge(String dateOfBirth) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date currentDate = new Date();
            Date date = dateFormat.parse(dateOfBirth);
            Calendar currentCalendar = Calendar.getInstance();

            Calendar dateCalendar = Calendar.getInstance();
            dateCalendar.setTime(date); 

            employeeAge = currentCalendar.get(Calendar.YEAR) - dateCalendar.get(Calendar.YEAR);
            
        } catch (ParseException e) {
            System.out.println(e);
        }
    }

    public int getEmployeeAge() {		
        return employeeAge;
    } 

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getEmployeeRole() {		
        return employeeRole;
    } 

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeGender() {		
        return employeeGender;
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

    public void setLeaveRecords(List leaveRecords) {
        this.leaveRecords = leaveRecords;
    }

    public List getLeaveRecords() {
        return leaveRecords;
    }

    @Override
    public String toString() {
        String displayEmployeeDetail = "\nEmployee Id : "+ employeeId + "\nEmployee Role : " + employeeRole + 
                                       "\nDepartment :" + employeeDepartment + "\nName : "+employeeName + 
                                       "\nDate of birth :" + employeeDateOfBirth + "\nPhone Number :" + employeePhoneNumber + 
                                       "\nEmail ID :" + employeeEmail + "\nAge :" + getEmployeeAge() + "\nGender : " + employeeGender + "\n";
        return displayEmployeeDetail;
    }	
}