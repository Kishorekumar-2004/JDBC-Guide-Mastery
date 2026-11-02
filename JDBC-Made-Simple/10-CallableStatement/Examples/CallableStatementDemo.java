package com.example.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String password = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             CallableStatement cs = conn.prepareCall("{call getStudentAge(?, ?)}")) {

            cs.setInt(1, 101);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();

            System.out.println("Student #101 Age: " + cs.getInt(2));
        } catch (SQLException e) {
            System.err.println("Procedure error: " + e.getMessage());
        }
    }
}
