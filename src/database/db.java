package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class    db {
    private static final String URL = "jdbc:postgresql://localhost:5432/library_db";
    private static final String USER = "postgres"; // your username
    private static final String PASSWORD = "kalibali"; // your password

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to PostgreSQL.");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }
}

