package com.van.jdbc;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://47.115.172.160:3306/test?useUnicode=true&characterEncoding=utf-8";
        String user = "root";
        String password = "123456";

        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        //编写sql
        String sql1 = "insert into person values (\"boy\",15)";
        //预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        //执行sql
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            System.out.println("success");
        }
        //关闭连接
        preparedStatement.close();
        connection.close();
    }
}
