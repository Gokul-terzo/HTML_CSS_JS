package com.mariadb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {
    public static void main(String[] args) {
        try {
            // Load the MariaDB JDBC driver
            Class.forName("org.mariadb.jdbc.Driver");

            // Establish a connection
            String url = "jdbc:mariadb://localhost:3306/database_name";
            String username = "your_username";
            String password = "your_password";
            Connection connection = DriverManager.getConnection(url, username, password);

            // Do something with the connection

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

