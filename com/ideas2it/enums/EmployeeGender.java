package com.ideas2it.enums;

public enum EmployeeGender {
    MALE(1),
    FEMALE(2),
    UNDEFINED(3);
    private final int value;

    private EmployeeGender(final int value) {
        this.value = value;
    }

    public static EmployeeGender getEmployeeGender(int userInput) {
        EmployeeGender genderType = null;
        for (EmployeeGender employeeGender : EmployeeGender.values()) {
            if(employeeGender.value == userInput) {
                genderType = employeeGender;
                break;
            }
        }
        return genderType;
    }
}