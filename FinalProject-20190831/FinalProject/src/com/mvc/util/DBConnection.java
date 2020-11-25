package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private final static String USER= "hr";
    private final static String PASSWORD= "admin"; //jdbc:mysql://localhost:3306/
    private final static String URL= "jdbc:oracle:thin:@localhost:1521:xe";
    private static Connection connection;
     
    public static Connection createConnection() throws SQLException, ClassNotFoundException{
        System.out.println("Printing connection object "+connection);
        if(connection == null || connection.isClosed()){
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
             System.out.println("Printing connection object "+connection);
        }
        return connection;
    }
}
