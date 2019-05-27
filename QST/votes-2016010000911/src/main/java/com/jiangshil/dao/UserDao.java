package com.jiangshil.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jiangshil.util.JDBCUtil;

public class UserDao {

    public static boolean login(String username, String password) {
        boolean flag = false;

        // ½á¹û¼¯
        ResultSet rs = null;
        JDBCUtil jdbc = new JDBCUtil();
        jdbc.getConnection();

        String sql = "select * from user where username = ? and password = ?";
        rs = jdbc.executeQuery(sql, new Object[]{username, password});

        try{
            if(rs.next()) {
                flag = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        jdbc.close();
        return flag;
    }
}

