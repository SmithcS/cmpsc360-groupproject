package classscheduler;

import java.sql.*;

public class Database {
    
    private static final String dbURL = "jdbc:derby://localhost:1527/CLASS_SCHEDULER";
    private static final String user = "java";
    private static final String pass = "java";
    private static Connection connection = null;
    
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(dbURL, user, pass);
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }
}
