package com.example.jdbc.flow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompleteJDBCFlowDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String pass = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        String query = "SELECT id, name, department FROM students";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("=== Complete Flow Output ===");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("Execution failed: " + e.getMessage());
        }
    }
}
