package com.ideas2it.model;

/**
 * <p> Contains every attribute for project record for
an employee, doesn't contain any i/o operation
 * </p>
 *
 */
public class EmployeeProjects {
   
    private String employeeId;
    private String projectName;
    private String projectManager;
    private String clientName;
    private String startDate;
    private String createdAt;
    private String modifiedAt;

    public EmployeeProjects(String employeeId, 
                            String projectName, 
                            String projectManager,
                            String clientName,
                            String startDate,
                            String createdAt,
                            String modifiedAt) {
        this.employeeId = employeeId;
        this.projectName = projectName;
        this.projectManager = projectManager;
        this.clientName = clientName;
        this.startDate = startDate;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public EmployeeProjects(String employeeId, 
                            String projectName, 
                            String projectManager,
                            String clientName,
                            String startDate) {
        this.employeeId = employeeId;
        this.projectName = projectName;
        this.projectManager = projectManager;
        this.clientName = clientName;
        this.startDate = startDate;
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


    @Override
    public String toString() {
        return "\nEmployeeId : "+ employeeId + "\nProject Name : " + projectName + 
               "\nProject Manager :" + projectManager + "\nClient Name : "+ clientName + 
               "\n Starting date : " + startDate + "\n";
    }	
}