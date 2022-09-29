package com.ideas2it.enums;

public enum LeaveType {
    SICK_LEAVE(1),
    CASUAL_LEAVE(2);
    private final int value;

    private LeaveType(final int value) {
        this.value = value;
    }

    public static LeaveType getLeaveType(int userInput) {
        LeaveType type = null;
        for (LeaveType leaveType : LeaveType.values()) {
            if(leaveType.value == userInput) {
                type = leaveType;
                break;
            }
        }
        return type;
    }
}