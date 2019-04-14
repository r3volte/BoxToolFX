package sample.Application.TEST;

import lombok.Getter;

@Getter
public class InitDatabaseInfo {

  private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/BoxTool?useSSL=false";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "icui4cu4";
  private static final String MAX_POOL = "250";
}
