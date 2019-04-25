package com.mydao.split.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    public static Connection getConn(String ip) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:oracle:thin:@"+ip+":1521:orcl";
        String username = "xztollstation";
        String password = "qwerty";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
