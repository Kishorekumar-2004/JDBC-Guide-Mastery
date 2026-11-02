package com.example.jdbc.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DBConnection {
    private static final Properties props = new Properties();

    static {
        try (InputStream in = DBConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (in != null) {
                props.load(in);
            }
        } catch (Exception ignored) {}
    }

    private DBConnection() {}

    public static Connection getConnection() throws SQLException {
        String url = System.getenv("DB_URL") != null ? System.getenv("DB_URL") :
                props.getProperty("db.url", "jdbc:mysql://localhost:3306/college_db");
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") :
                props.getProperty("db.user", "root");
        String pass = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") :
                props.getProperty("db.password", "root123");

        return DriverManager.getConnection(url, user, pass);
    }
}
