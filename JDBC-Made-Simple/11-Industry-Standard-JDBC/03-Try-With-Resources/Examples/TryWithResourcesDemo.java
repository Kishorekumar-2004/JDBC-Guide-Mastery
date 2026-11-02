package com.example.jdbc.cleanup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TryWithResourcesDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String pass = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        String sql = "SELECT name, department FROM students WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, 101);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Fetched: " + rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Safe handling: " + e.getMessage());
        }
    }
}
