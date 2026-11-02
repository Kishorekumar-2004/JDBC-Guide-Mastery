package com.example.jdbc;

import com.example.jdbc.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== JDBC Learning Project Entry Point ===");
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM students");
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                System.out.println("Total students in database: " + rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
