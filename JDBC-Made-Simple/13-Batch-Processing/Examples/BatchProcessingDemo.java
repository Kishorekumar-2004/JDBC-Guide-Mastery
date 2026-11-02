package com.example.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchProcessingDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String pass = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        String sql = "INSERT INTO students (id, name, age, department) VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE name=name";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);
            for (int i = 201; i <= 205; i++) {
                ps.setInt(1, i);
                ps.setString(2, "BatchStudent" + i);
                ps.setInt(3, 20);
                ps.setString(4, "CSE");
                ps.addBatch();
            }

            int[] counts = ps.executeBatch();
            conn.commit();
            System.out.println("Inserted " + counts.length + " batched records successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
