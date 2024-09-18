package vn.hcmute.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectMySQL {
    private static String USERNAME = "root";
    private static String PASSWORD = "170804";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/ltweb";

    public Connection getDatabaseConnection() throws Exception{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

//    public static void main(String[] args) {
//        DBConnectMySQL db = new DBConnectMySQL();
//        try {
//            System.out.println(db.getDatabaseConnection());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
