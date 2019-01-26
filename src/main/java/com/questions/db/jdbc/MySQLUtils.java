package com.questions.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Jitendra Kumar : 12/9/18
 */
public class MySQLUtils {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc", "root", "password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static Connection getConnection1() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:mysql://localhost:3306/mysqljdbc";
            String user = "root";
            String password = "password";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
