package com.ideas2it.dao;

import com.ideas2it.model.EmployeeProjects;
import com.ideas2it.connection.ConnectorInfo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet; 
import java.sql.SQLException;
   
import java.util.List;
import java.util.ArrayList;


public class EmployeeProjectsDaoImpl implements EmployeeProjectsDao {
    Connection connection;

    @Override
    public boolean addEmployeeProject(EmployeeProjects record) {
        try {
            connection = ConnectorInfo.createConnection();
            String insertElementQuery = " INSERT INTO employee_projects (employee_id, name, manager, client, start_date, createdAt, modifiedAt)"
                                                                      + "VALUES('"+record.getEmployeeId()+"',"
                                                                      + "'"+record.getProjectName()+"',"
                                                                      + "'"+record.getProjectManager()+"',"
                                                                      + "'"+record.getClientName()+"',"
                                                                      + "'"+record.getStartDate()+"',"
                                                                      + "'"+record.getCreatedAt()+"',"
                                                                      + "'"+record.getModifiedAt()+"')";
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
    public EmployeeProjects getEmployeeProject(String employeeId) {
        EmployeeProjects employeeProject = null;
        
        try {
            connection = ConnectorInfo.createConnection();
            String insertElementQuery = " SELECT * FROM employee_projects WHERE employee_id= '"+employeeId+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(insertElementQuery);
            while(resultSet.next()) {
                employeeProject = new EmployeeProjects(resultSet.getString("employee_id"),
                                                       resultSet.getString("name"), 
                                                       resultSet.getString("manager"),
                                                       resultSet.getString("client"),
                                                       resultSet.getString("start_date"));
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        } finally {
            ConnectorInfo.closeConnection();
        }
        return employeeProject;
    }

    @Override
    public boolean updateEmployeeProjects(EmployeeProjects employeeProjects) {
         try {
            connection = ConnectorInfo.createConnection();
            String insertElementQuery = " UPDATE employee_projects SET name ='"+employeeProjects.getProjectName()+"',"
                                                                    + "manager ='"+employeeProjects.getProjectManager()+"',"
                                                                    + "client ='"+employeeProjects.getClientName()+"',"
                                                                    + "start_date ='"+employeeProjects.getStartDate()+"',"
                                                                    + "modifiedAt ='"+employeeProjects.getModifiedAt()+"'"
                                                                    + "WHERE employee_id ='"+employeeProjects.getEmployeeId()+"'";
            Statement statement = connection.createStatement();
            return statement.execute(insertElementQuery);
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        } finally {
            ConnectorInfo.closeConnection();
        }
        return true;
    }
}
