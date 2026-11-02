package com.example.jdbc.modern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ModernJDBCDemo.java
 * Demonstrates modern industry-standard coding style.
 */
public class ModernJDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/college_db";
    private static final String USER = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
    private static final String PASS = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

    public static void main(String[] args) {
        String sql = "SELECT id, name, department FROM students WHERE department = ?";

        // Modern try-with-resources
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "Computer Science");
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("=== Modern JDBC Execution ===");
                while (rs.next()) {
                    System.out.println("Student: " + rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Database operation failed: " + e.getMessage());
        }
    }
}
