package com.kainos.ea.util;

import com.kainos.ea.exception.DatabaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static Connection conn;

    //Opens the database connection
    public static Connection getConnection() throws SQLException {
        String user;
        String password;
        String host;
        String database;

        if (conn != null && !conn.isClosed()) {
            return conn;
        }

        try {
            user = System.getenv("DB_USERNAME");
            password = System.getenv("DB_PASSWORD");
            host = System.getenv("DB_HOST");
            database = System.getenv("DB_NAME");

            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Environment variables not set.");

            conn = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/" + database + "?allowPublicKeyRetrieval=true&useSSL=false", user, password);

            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            closeConnection();

        }
        return null;
    }

    public static void closeConnection() throws SQLException {
        try{
            if (conn != null) {
                conn.close();
                conn = null;
            }
        }catch (Exception e ){
            throw new SQLException();
        }
    }
}