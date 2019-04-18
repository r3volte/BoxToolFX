package sample.Application.TEST;

import java.sql.*;

public class SQL_DB {

  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

    String url = "jdbc:mysql://127.0.0.1:3306/BoxTool?useSSL=false";
    String user = "root";
    String password = "icui4cu4";

// Load the Connector/J driver
    Class.forName("com.mysql.jdbc.Driver").newInstance();
// Establish connection to TEST
    Connection conn = DriverManager.getConnection(url, user, password);
  }
}
