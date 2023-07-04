package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    private static final String URL_DB = "jdbc:mysql://localhost:3308/classicmodels";
    private static final String USER_DB = "root";
    private static final String USER_PWD = "";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL_DB, USER_DB, USER_PWD);
            System.out.println(conn + " is open");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void release(Connection conn){
        try {
            if(conn != null){
                conn.close();
                System.out.println(conn + " is closed");
            }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
