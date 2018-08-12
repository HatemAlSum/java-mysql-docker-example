package com.cloud9ers.sample.mysql;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    public static void main(String[] args) throws Exception {
        createSchema();
        System.out.print("Database Connection Succeded");
    }

    private static void createSchema() throws SQLException {
        Connection connection = getConnection();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DROP DATABASE IF EXISTS messagesdb");
        stmt.executeUpdate("CREATE DATABASE messagesdb");
        stmt.executeUpdate("use messagesdb");
        stmt.executeUpdate("DROP TABLE IF EXISTS messages");
        stmt.executeUpdate("CREATE TABLE messages (id INT AUTO_INCREMENT, message VARCHAR(45), PRIMARY KEY (id))");
        connection.close();
    }

    protected static Connection getConnection() throws SQLException {
        System.out.println("Loading driver...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        String host = System.getenv("MYSQLS_HOSTNAME");
        String port = System.getenv("MYSQLS_PORT");
        String database = System.getenv("MYSQLS_DATABASE");
        String username = System.getenv("MYSQLS_USERNAME");
        String password = System.getenv("MYSQLS_PASSWORD");
        String dbUrl = "jdbc:mysql://" + host + ":" + port + "/" + database;
        return DriverManager.getConnection(dbUrl, username, password);
    }
}
