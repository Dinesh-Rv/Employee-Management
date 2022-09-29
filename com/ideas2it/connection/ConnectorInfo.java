package com.ideas2it.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorInfo {

    private static Connection connection = null;

    private ConnectorInfo() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/office",
                                                 "root",
                                                 "dineshideas2it");
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        } 
    }

    public static Connection createConnection() throws SQLException {
        if(connection == null || connection.isClosed()) {
            ConnectorInfo connectorInfo = new ConnectorInfo();
        }    
        return connection;
    }   

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }    
    }
}