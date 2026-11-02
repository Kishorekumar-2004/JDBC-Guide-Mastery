package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionDemo.java
 * Demonstrates establishing a real connection to MySQL college_db.
 */
public class ConnectionDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String password = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        System.out.println("=== JDBC Connection Demo ===");
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successfully established!");
            System.out.println("Catalog: " + conn.getCatalog());
            System.out.println("Auto-commit status: " + conn.getAutoCommit());
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
    }
}
