package com.example.jdbc.bestpractices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BestPracticesDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String pass = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        // Query with query timeout set
        String sql = "SELECT id, name FROM students WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Best Practice: Prevent queries from hanging indefinitely
            ps.setQueryTimeout(5); // 5 seconds timeout
            ps.setInt(1, 101);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Fetched safely: " + rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}
