package org.krishnalT.utils;

import java.sql.*;

public class DBUtils {
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

    // Connect to Database
    public static void connectToDB(String dbURL, String user, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, user, password);
            stmt = conn.createStatement();
            System.out.println("✅ Connected to Database successfully!");
        } catch (SQLException e) {
            System.err.println("❌ Error connecting to the database: " + e.getMessage());
        }
    }

    // Execute SQL Query
    public static ResultSet executeQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("❌ SQL Query Error: " + e.getMessage());
        }
        return rs;
    }

    // Validate User Exists
    public static boolean validateUserExists(String email) {
        String query = "SELECT COUNT(*) FROM Users WHERE Email = '" + email + "'";
        try {
            rs = stmt.executeQuery(query);
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("✅ User " + email + " found in the database.");
                return true;
            } else {
                System.out.println("❌ User " + email + " not found.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("❌ Validation Error: " + e.getMessage());
        }
        return false;
    }

    // Close Connection
    public static void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
            System.out.println("✅ Database connection closed.");
        } catch (SQLException e) {
            System.err.println("❌ Error closing DB connection: " + e.getMessage());
        }
    }
}
