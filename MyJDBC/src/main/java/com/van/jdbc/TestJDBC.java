package com.van.jdbc;

import org.junit.Test;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://47.115.172.160:3306/test?useUnicode=true&characterEncoding=utf-8";
        String user = "root";
        String password = "123456";

        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        //sql对象statement
        Statement statement = connection.createStatement();
        //编写sql
        String sql = "select * from person";
        //String sql1 = "insert into person values (\"boy\",15)";
        //执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        //statement.executeUpdate(sql1);

        while (resultSet.next()) {
            System.out.println(resultSet.getObject("name") + ":" +resultSet.getObject("age"));
        }

        //关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }

    //使用junit的标签，可以直接执行方法
    @Test
    public void say() {
        System.out.println("叼你");
    }
}
