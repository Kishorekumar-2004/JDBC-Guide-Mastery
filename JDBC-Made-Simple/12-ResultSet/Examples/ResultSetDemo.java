package com.example.jdbc.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String pass = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement("SELECT id, name FROM students");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " - " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("ResultSet Error: " + e.getMessage());
        }
    }
}
