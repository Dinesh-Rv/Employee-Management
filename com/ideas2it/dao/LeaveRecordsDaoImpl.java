package com.ideas2it.dao;

import com.ideas2it.model.LeaveRecords;
import com.ideas2it.enums.LeaveType;
import com.ideas2it.connection.ConnectorInfo;
import com.ideas2it.model.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction; 
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

import javax.persistence.Query;  

import java.util.List;
import java.util.ArrayList;

public class LeaveRecordsDaoImpl implements LeaveRecordsDao {
    
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public String addLeaveRecord(LeaveRecords record, String employeeId) {
        List <LeaveRecords> leaveRecord = new ArrayList<LeaveRecords>();
        leaveRecord.add(record);
        Session session = null;

        try { 
            session = sessionFactory.openSession();
            Transaction transact = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, employeeId);
            employee.setLeaveRecords(leaveRecord);
            session.save(employee);
            transact.commit();
        } catch (HibernateException h) {
            System.out.println(h);
        }

        return employeeId;
    }

    @Override
    public List<LeaveRecords> getLeaveRecords(String employeeId) {
        List<LeaveRecords> leaveRecords = new ArrayList<LeaveRecords>();
       
        return leaveRecords;
    }

    @Override
    public boolean updateLeaveRecords(LeaveRecords leaveRecords) {
        return true;
    }

    @Override
    public LeaveRecords getLeaveRecord(String employeeId, int userLeaveRecordId) {
        LeaveRecords leaveRecord = null;
        
        return leaveRecord;
    }
}
