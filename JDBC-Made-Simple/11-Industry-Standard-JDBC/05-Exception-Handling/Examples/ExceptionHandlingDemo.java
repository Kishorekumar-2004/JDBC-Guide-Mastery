package com.example.jdbc.exceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String pass = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        // Deliberately trigger duplicate primary key exception
        String sql = "INSERT INTO students (id, name, age, department) VALUES (101, 'Duplicate Alice', 20, 'CS')";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("=== Caught SQLException ===");
            System.err.println("Message:   " + e.getMessage());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());

            if (e.getErrorCode() == 1062) {
                System.err.println("Diagnosis: Primary Key Violation (id 101 already exists)!");
            }
        }
    }
}
