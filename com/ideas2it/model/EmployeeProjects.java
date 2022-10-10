package com.ideas2it.model;

import java.util.Collection;
import java.util.List;

/**
 * <p> Contains every attribute for project record for
an employee, doesn't contain any i/o operation
 * </p>
 *
 */
public class EmployeeProjects {
    private int projectId;
    private String employeeId;
    private String projectName;
    private String projectManager;
    private String clientName;
    private String startDate;
    private String createdAt;
    private String modifiedAt;

    private List<Employee> employee;

    private int deleted;

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public  EmployeeProjects() {

    }

    public EmployeeProjects(String projectName,
                            String projectManager,
                            String clientName,
                            String startDate,
                            String createdAt,
                            String modifiedAt) {
        this.projectName = projectName;
        this.projectManager = projectManager;
        this.clientName = clientName;
        this.startDate = startDate;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    } 


    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
	
    public String getProjectName() {
        return projectName;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }	

    public String getProjectManager() {
        return projectManager;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
	
    public String getClientName() {
        return clientName;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }	

    public String getStartDate() {
        return startDate;
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

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "\nProject Id : "+ projectId + "\nProject Name : " + projectName +
               "\nProject Manager :" + projectManager + "\nClient Name : "+ clientName + 
               "\n Starting date : " + startDate + "\n";
    }
}