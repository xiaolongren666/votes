package com.jiangshil.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

    //静态常量
    private static final String URL = "jdbc:mysql://10.18.31.220:3306/mybatis?characterEncoding=utf-8";
    private static final String DRIVER = "com.mysql.jdbc.Driver";//数据库版本5系
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // 连接数据库。
    public Connection getConnection() {
        // 1.加载数据库驱动。
        try {
            Class.forName(DRIVER);

            // 2.建立数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }


    /**
     * 增删改  操作
     * @param sql 增删改的sql语句
     * @param objects 传递过来的参数数组
     * @return
     */
    public int executeUpdate(String sql,Object[] objects) {
        int flag = 0;

        try {
            ps = conn.prepareStatement(sql);
            if (objects != null) {
                for (int i = 0; i < objects.length; i++) {
                    ps.setObject(i+1, objects[i]);
                }
            }
            flag = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 查询操作
     * @param sql 查询的sql语句
     * @param objects 传递的参数数组
     * @return
     */
    public ResultSet executeQuery(String sql,Object[] objects) {

        try {
            ps = conn.prepareStatement(sql);
            if (objects != null) {
                for (int i = 0; i < objects.length; i++) {
                    ps.setObject(i+1, objects[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return rs;
    }


    //关闭
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

