package com.example.jdbc.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MetadataDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String pass = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            DatabaseMetaData dbmd = conn.getMetaData();
            System.out.println("Connected to: " + dbmd.getDatabaseProductName() + " v" + dbmd.getDatabaseProductVersion());

            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM students LIMIT 1");
                 ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.println("Col " + i + ": " + rsmd.getColumnName(i) + " (" + rsmd.getColumnTypeName(i) + ")");
                }
            }
        } catch (SQLException e) {
            System.err.println("Metadata error: " + e.getMessage());
        }
    }
}
