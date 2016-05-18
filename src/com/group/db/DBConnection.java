package com.group.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Created by lahiru on 5/17/2016.
 */
public class DBConnection {
    // parameters for JDBC
    private String url = "jdbc:mysql://localhost/batmap_db";
    private String user = "lahiru";
    private String pass = "lahiru";
    private String driver = "com.mysql.jdbc.Driver";
    private Connection connection;

    public Connection getConnection() throws ClassNotFoundException,
            SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, pass);
        System.out.println("Connection to db success!");
        return connection;
    }

    public static void printError(Exception e) {
        System.err.println("ERROR: " + e.getMessage());

    }


}
