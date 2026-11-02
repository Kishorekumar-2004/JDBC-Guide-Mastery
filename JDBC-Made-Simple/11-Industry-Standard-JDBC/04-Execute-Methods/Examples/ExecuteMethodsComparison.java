package com.example.jdbc.methods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteMethodsComparison {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String pass = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            // 1. executeUpdate()
            try (PreparedStatement psUpdate = conn.prepareStatement("UPDATE students SET age = age + 0 WHERE id = ?")) {
                psUpdate.setInt(1, 101);
                int count = psUpdate.executeUpdate();
                System.out.println("executeUpdate() returned row count: " + count);
            }

            // 2. executeQuery()
            try (PreparedStatement psSelect = conn.prepareStatement("SELECT name FROM students WHERE id = ?")) {
                psSelect.setInt(1, 101);
                try (ResultSet rs = psSelect.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("executeQuery() returned row: " + rs.getString(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
