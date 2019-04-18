package sample.Application.TEST;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Getter
public class InitDatabaseInfo implements DiscDatabase {

  private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/BoxTool?useSSL=false";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "icui4cu4";
  private static final String MAX_POOL = "250";

  private Properties properties;
  private Connection connection;


  public Properties getProperties() {
    if (properties == null) {
      properties = new Properties();
      properties.setProperty("user", USERNAME);
      properties.setProperty("password", PASSWORD);
      properties.setProperty("MaxPooledStatements", MAX_POOL);
    }
    return properties;
  }

  public Connection connect() {
    if (connection == null) {
      try {
        Class.forName(DATABASE_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, getProperties());
      } catch (ClassNotFoundException | SQLException e) {
        // Java 7+
        e.printStackTrace();
      }
    }
    return connection;
  }

  @Override
  public void disconnect() {
    if (connection != null) {
      try {
        connection.close();
        connection = null;
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
