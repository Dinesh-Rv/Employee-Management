package com.ideas2it.dao;

import com.ideas2it.model.LeaveRecords;
import com.ideas2it.enums.LeaveType;
import com.ideas2it.connection.ConnectorInfo;
import com.ideas2it.model.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction; 
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

import javax.persistence.Query;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet; 
import java.sql.SQLException;   

import java.util.List;
import java.util.ArrayList;

public class LeaveRecordsDaoImpl implements LeaveRecordsDao {
    
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private Connection connection;

    @Override
    public boolean addLeaveRecord(LeaveRecords record, employeeId) {
        Session session = null;
        try { 
            session = sessionFactory.openSession();
            Transaction transact = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, employeeId);
            employee.setLeaveRecords(record);
            leaveId = (Integer) session.save(employee);
            transact.commit();
        } catch (HibernateException h) {
            System.out.println(h);
        } finally {
            if(session != null) {
                session.close();
            }          
        }
        return employeeId;
    }

    @Override
    public List<LeaveRecords> getLeaveRecords(String employeeId) {
        List<LeaveRecords> leaveRecords = new ArrayList<LeaveRecords>();
        
        try {
            connection = ConnectorInfo.createConnection();
            String insertElementQuery = " SELECT * FROM leave_records WHERE employee_id= '"+employeeId+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(insertElementQuery);
            while(resultSet.next()) {
                LeaveRecords leaveRecord = new LeaveRecords(resultSet.getInt("id"),
                                                            resultSet.getString("employee_id"),
                                                            resultSet.getString("from_date"), 
                                                            resultSet.getString("to_date"),
                                                            resultSet.getString("leave_type"));
                leaveRecords.add(leaveRecord);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        } finally {
            ConnectorInfo.closeConnection();
        }
        return leaveRecords;
    }

    @Override
    public boolean updateLeaveRecords(LeaveRecords leaveRecords) {
         try {
            connection = ConnectorInfo.createConnection();
            String insertElementQuery = " UPDATE leave_records SET from_date ='"+leaveRecords.getFromDate()+"',"
                                                                + "to_date ='"+leaveRecords.getToDate()+"',"
                                                                + "leave_type ='"+leaveRecords.getLeaveType()+"',"
                                                                + "modifiedAt ='"+leaveRecords.getModifiedAt()+"'"
                                                                + "WHERE employee_id ='" +leaveRecords.getEmployeeId()+"'AND"
                                                                + " id='"+leaveRecords.getLeaveRecordId()+"'" ;

            Statement statement = connection.createStatement();
            return statement.execute(insertElementQuery);
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        } finally {
            ConnectorInfo.closeConnection();
        }
        return true;
    }

    @Override
    public LeaveRecords getLeaveRecord(String employeeId, int userLeaveRecordId) {
        LeaveRecords leaveRecord = null;
        
        try {
            connection = ConnectorInfo.createConnection();
            String insertElementQuery = " SELECT * FROM leave_records WHERE employee_id= '"+employeeId+"'"
                                                                  + "AND id='"+userLeaveRecordId+"'" ;     
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(insertElementQuery);
            while(resultSet.next()) {
                leaveRecord = new LeaveRecords(resultSet.getInt("id"),
                                               resultSet.getString("employee_id"),
                                               resultSet.getString("from_date"), 
                                               resultSet.getString("to_date"),
                                               resultSet.getString("leave_type"));
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        } finally {
            ConnectorInfo.closeConnection();
        }
        return leaveRecord;
    }
}
