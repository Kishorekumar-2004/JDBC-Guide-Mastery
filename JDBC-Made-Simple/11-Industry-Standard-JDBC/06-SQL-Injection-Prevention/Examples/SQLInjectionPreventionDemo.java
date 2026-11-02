package com.example.jdbc.security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLInjectionPreventionDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String pass = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        // Simulated malicious payload
        String maliciousInput = "' OR '1'='1";

        System.out.println("=== Testing Malicious Input with PreparedStatement ===");
        String safeQuery = "SELECT id, name FROM students WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(safeQuery)) {

            ps.setString(1, maliciousInput);

            try (ResultSet rs = ps.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println("Found: " + rs.getString("name"));
                }
                if (!found) {
                    System.out.println("SAFE: No records returned. The SQL Injection attack was safely neutralized!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
