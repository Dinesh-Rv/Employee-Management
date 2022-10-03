package com.ideas2it.service;

import com.ideas2it.model.LeaveRecords;
import com.ideas2it.model.Employee;

import com.ideas2it.dao.LeaveRecordsDao;
import com.ideas2it.dao.LeaveRecordsDaoImpl;

import java.util.List;

public class LeaveRecordsServiceImpl implements LeaveRecordsService {

    private LeaveRecordsDao leaveRecordsDaoImpl = new LeaveRecordsDaoImpl();

    public int addLeaveRecord(LeaveRecords record) {
        return leaveRecordsDaoImpl.addLeaveRecord(record);
    }

    public List<LeaveRecords> getLeaveRecords(Employee employee) {
        return leaveRecordsDaoImpl.getLeaveRecords(employee);
    }

    public boolean updateLeaveRecords(LeaveRecords leaveRecords) {
         return leaveRecordsDaoImpl.updateLeaveRecords(leaveRecords);
    }

    public LeaveRecords getLeaveRecord(String employeeId, int leaveRecordId) {
        return leaveRecordsDaoImpl.getLeaveRecord(employeeId, leaveRecordId);
    }
}