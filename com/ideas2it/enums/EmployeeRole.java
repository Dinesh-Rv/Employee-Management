package com.ideas2it.enums;

public enum EmployeeRole {
    TRAINER(1),
    TRAINEE(2);
    private final int roleValue;
 
    private EmployeeRole(final int roleValue) {
        this.roleValue = roleValue;
    }

    public static EmployeeRole getEmployeeRole(int userInput) {
        EmployeeRole roleType = null; 
        for (EmployeeRole employeeRole:EmployeeRole.values()) {
            if(employeeRole.roleValue == userInput) {
                roleType = employeeRole;
                break;
            }
        }
        return roleType;
    }
}