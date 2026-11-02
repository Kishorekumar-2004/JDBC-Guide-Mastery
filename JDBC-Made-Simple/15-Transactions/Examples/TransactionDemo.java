package com.example.jdbc.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String pass = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root123";

        String update1 = "UPDATE students SET age = age + 1 WHERE id = ?";
        String update2 = "UPDATE students SET department = ? WHERE id = ?";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
            // 1. Disable auto-commit to begin transaction
            conn.setAutoCommit(false);

            try (PreparedStatement ps1 = conn.prepareStatement(update1);
                 PreparedStatement ps2 = conn.prepareStatement(update2)) {

                // Operation 1
                ps1.setInt(1, 101);
                ps1.executeUpdate();

                // Operation 2
                ps2.setString(1, "Artificial Intelligence");
                ps2.setInt(2, 101);
                ps2.executeUpdate();

                // 2. Commit transaction permanently
                conn.commit();
                System.out.println("Transaction committed successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Transaction failed! Rolling back changes...");
            if (conn != null) {
                try {
                    // 3. Rollback all operations on failure
                    conn.rollback();
                    System.err.println("Rollback complete. Database returned to original state.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); // Reset to default
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
