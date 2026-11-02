package com.example.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionLifecycleDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String pass = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Connection active: " + !conn.isClosed());
            System.out.println("AutoCommit: " + conn.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
