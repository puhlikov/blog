package com.epam.training.connection;
/**
 * com.epam.training.connection
 * @author Pavel Bukhtsiyarau
 */

import java.sql.*;
/* Create connection with MySQL */
public class MySQLConnector {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/books";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            return DriverManager.getConnection(DB_URL,
                    DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error com.epam.training.connection.");
            throw new RuntimeException();
        }
    }

    /** Close connection */

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Can't close the com.epam.training.connection.");
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            System.err.println("Can't close the com.epam.training.connection.");
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.err.println("Can't close the com.epam.training.connection.");
        }
    }

    public static void closeStatements(Statement ... statements) {
        try {
            if (statements.length != 0) {
                for (Statement statement : statements) {
                    statement.close();
                }
            }
        } catch (SQLException e) {
            System.err.println("Can't close the com.epam.training.connection.");
        }
    }
}
