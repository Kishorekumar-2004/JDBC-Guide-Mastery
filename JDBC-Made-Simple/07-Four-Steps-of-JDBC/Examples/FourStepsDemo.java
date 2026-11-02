package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class FourStepsDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String password = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, department FROM students")) {

            System.out.println("=== The 4 Basic Steps of JDBC Demo ===");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %-15s | Dept: %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getString("department"));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
