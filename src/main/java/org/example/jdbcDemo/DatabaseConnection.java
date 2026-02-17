package org.example.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    public static Connection getConnection()
    {
        String url="jdbc:mysql://localhost:3306/jdbc_demo";
        String username="root";
        String Password="Praveen@12";
        try {
            connection= DriverManager.getConnection(url,username,Password);

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
