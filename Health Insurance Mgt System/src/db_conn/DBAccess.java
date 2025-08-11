package db_conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAccess {

    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private final String health_insurance_management_system = "health_insurance_management_system";  // ✅ Replace with your DB name
    private final String URL = "jdbc:mysql://localhost/" + health_insurance_management_system;
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private Connection connection;

    public DBAccess() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("✅ Database connected successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Failed to connect to database.");
            e.printStackTrace();
        }
    }

    // ✅ This method fixes the error in Main.java
    public Connection getConnection() {
        return connection;
    }
}

