package com.ideas2it.service;

import com.ideas2it.model.LeaveRecords;
import com.ideas2it.dao.LeaveRecordsDao;
import com.ideas2it.dao.LeaveRecordsDaoImpl;

import java.util.List;

public class LeaveRecordsServiceImpl implements LeaveRecordsService {

    private LeaveRecordsDao leaveRecordsDaoImpl = new LeaveRecordsDaoImpl();

    public String addLeaveRecord(LeaveRecords record, String employeeId) {
        return leaveRecordsDaoImpl.addLeaveRecord(record, employeeId);
    }

    public List<LeaveRecords> getLeaveRecords(String employeeId) {
        return leaveRecordsDaoImpl.getLeaveRecords(employeeId);
    }

    public boolean updateLeaveRecords(LeaveRecords leaveRecords) {
         return leaveRecordsDaoImpl.updateLeaveRecords(leaveRecords);
    }

    public LeaveRecords getLeaveRecord(String employeeId, int leaveRecordId) {
        return leaveRecordsDaoImpl.getLeaveRecord(employeeId, leaveRecordId);
    }
}