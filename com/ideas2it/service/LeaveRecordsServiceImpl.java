package com.ideas2it.service;

import com.ideas2it.model.LeaveRecords;
import com.ideas2it.model.Employee;

import com.ideas2it.dao.LeaveRecordsDao;
import com.ideas2it.dao.LeaveRecordsDaoImpl;

import java.util.List;

public class LeaveRecordsServiceImpl implements LeaveRecordsService {

    private LeaveRecordsDao leaveRecordsDaoImpl = new LeaveRecordsDaoImpl();

    @Override
    public int addLeaveRecord(LeaveRecords record) {
        return leaveRecordsDaoImpl.addLeaveRecord(record);
    }

    @Override
    public List<LeaveRecords> getLeaveRecords(Employee employee) {
        return leaveRecordsDaoImpl.getLeaveRecords(employee);
    }

    @Override
    public boolean updateLeaveRecords(LeaveRecords leaveRecords) {
         return leaveRecordsDaoImpl.updateLeaveRecords(leaveRecords);
    }

    @Override
    public LeaveRecords getLeaveRecordById(int userLeaveRecordId) {
        return leaveRecordsDaoImpl.getLeaveRecordById(userLeaveRecordId);
    }
   
    @Override
    public void removeEmployeeLeaveRecords(Employee employee) {
        System.out.println("inside removing all leav rec");
        leaveRecordsDaoImpl.removeEmployeeLeaveRecords(employee);
    }
}