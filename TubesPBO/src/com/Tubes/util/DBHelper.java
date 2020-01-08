package com.Tubes.util;

//Silvia Tiffani 1772010

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/TubesPBO";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection createMySQLConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        connection.setAutoCommit(false);
        return connection;
    }
}
