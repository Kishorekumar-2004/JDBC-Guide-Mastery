package com.example.jdbc;

/**
 * DriverTest.java
 * Simple test to verify that MySQL Connector/J is properly added to classpath.
 */
public class DriverTest {
    public static void main(String[] args) {
        System.out.println(=== Testing MySQL JDBC Driver Setup ===);
        try {
            Class.forName(com.mysql.cj.jdbc.Driver);
            System.out.println(SUCCESS: com.mysql.cj.jdbc.Driver loaded successfully!);
            System.out.println(Your Java environment is ready for JDBC connections.);
        } catch (ClassNotFoundException e) {
            System.err.println(FAILURE: MySQL Driver class not found!);
            System.err.println(Make sure mysql-connector-j.jar is added to your project classpath.);
        }
    }
}
