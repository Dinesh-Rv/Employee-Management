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
import org.hibernate.Query;

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
    public List<LeaveRecords> getLeaveRecords(Employee employee) {
        List<LeaveRecords> leaveRecords = new ArrayList<LeaveRecords>();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transact = session.beginTransaction();
            Query query = session.createQuery("FROM LeaveRecords WHERE DELETED = 0 AND employee = :employee");
            System.out.println("after create query");
            query.setParameter("employee", employee.getEmployeeId());
            System.out.println("after set param");
            leaveRecords = query.list();
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
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transact = session.beginTransaction();
            System.out.println(leaveRecords);
            session.update(leaveRecords);
            transact.commit();
            return true;
        } catch (HibernateException h) {
            System.out.println(h);
        } finally {
            if(session != null) {
                session.close();
            }          
        }
        return false;
    } 

    @Override
    public LeaveRecords getLeaveRecordById(int userLeaveRecordId) {
        LeaveRecords leaveRecord = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transact = session.beginTransaction();
            leaveRecord = (LeaveRecords) session.get(LeaveRecords.class, userLeaveRecordId);
        } catch (HibernateException h) {
            System.out.println(h);
        } finally {
            if(session != null) {
                session.close();
            }          
        }
        return leaveRecord;
    }
}
