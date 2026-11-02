package com.example.jdbc.procedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class StoredProcedureDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String pass = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             CallableStatement cs = conn.prepareCall("{call getStudentAge(?, ?)}")) {

            cs.setInt(1, 101);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();

            System.out.println("Procedure result (Age): " + cs.getInt(2));
        } catch (SQLException e) {
            System.err.println("Procedure call error: " + e.getMessage());
        }
    }
}
