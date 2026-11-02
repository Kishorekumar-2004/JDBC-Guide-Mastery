package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String password = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        String query = "SELECT id, name, department FROM students WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, 101);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Found student: " + rs.getString("name") + " in " + rs.getString("department"));
                }
            }
        } catch (SQLException e) {
            System.err.println("PreparedStatement error: " + e.getMessage());
        }
    }
}
