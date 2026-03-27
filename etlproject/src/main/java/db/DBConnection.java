package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/etl_db";
    private static final String USER = "root";
    private static final String PASSWORD = "2004";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Connection getSourceConnection() throws Exception {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/source_db", USER, PASSWORD);
    }

    public static Connection getTargetConnection() throws Exception {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/target_db", USER, PASSWORD);
    }

}
