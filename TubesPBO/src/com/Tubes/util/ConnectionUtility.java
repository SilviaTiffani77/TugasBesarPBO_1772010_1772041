package com.Tubes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtility {
  private static final String URL = "jdbc:mysql://localhost:3306/pbo2w04";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "";


  public static Connection createConnection() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection(URL, USERNAME,
              PASSWORD);
      return conn;
    } catch (ClassNotFoundException | SQLException ex) {
      Logger.getLogger(ConnectionUtility.class.getName()).
              log(Level.SEVERE, null,
                      ex);
    }
    return null;
  }
}
