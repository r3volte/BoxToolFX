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


  public void testConnection() {
    String url = "jdbc:mysql://127.0.0.1:3306/BoxTool";
    String username = "root";
    String password = "icui4cu4";

    System.out.println("Connecting database...");

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      System.out.println("Database connected!");
    } catch (SQLException e) {
      throw new IllegalStateException("Cannot connect the database!", e);
    }
  }

  private void driverLoader(){
    System.out.println("Loading driver...");

    try {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded!");
    } catch (ClassNotFoundException e) {
      throw new IllegalStateException("Cannot find the driver in the classpath!", e);
    }
  }
}
