package Handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHandler {
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String connectionString = "jdbc:mysql://localhost:3306/harbour?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
    private static final String login = "root";
    private static final String password = "root";


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        return   DriverManager.getConnection(connectionString,login,password);
    }
}
