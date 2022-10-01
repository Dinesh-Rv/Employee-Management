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
    public int addLeaveRecord(LeaveRecords record) {
        int leaveId = 0;
        Session session = null;
        try { 
            session = sessionFactory.openSession();
            Transaction transact = session.beginTransaction();
            leaveId = (Integer)session.save(record);
            System.out.println(leaveId);
            transact.commit();
        } catch (HibernateException h) {
            System.out.println(h);
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return leaveId;
    }

    @Override
    public List<LeaveRecords> getLeaveRecords(String employeeId) {
        List<LeaveRecords> leaveRecords = new ArrayList<LeaveRecords>();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transact = session.beginTransaction();
            Query query = session.createQuery("FROM LeaveRecords WHERE DELETED = 0 AND employeeId = :employeeId");
            query.setParameter("employeeId", employeeId);
            leaveRecords = query.getResultList();
            transact.commit();
        } catch (HibernateException h) {
            System.out.println(h);
        } finally {
            if(session != null) {
                session.close();
            }          
        }
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
