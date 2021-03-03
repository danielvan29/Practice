package com.van.jdbc;

import org.junit.Test;

import java.sql.*;

public class TransactionTest {
    @Test
    public void debit() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://47.115.172.160:3306/test?useUnicode=true&characterEncoding=utf-8";
        String user = "root";
        String password = "123456";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        //开启事务
        connection.setAutoCommit(false);
        try {
            String sql = "update account set bal = bal - 100 where id = 1";
            connection.prepareStatement(sql).executeUpdate();

            int i = 1 / 0;

            String sql1 = "update account set bal = bal + 100 where id = 2";
            connection.prepareStatement(sql1).executeUpdate();

            connection.commit();
            System.out.println("debit success");
        } catch (Exception e) {
            connection.rollback();
            System.out.println("debit fail");
        } finally {
          connection.close();
            System.out.println("debit finish");
        }


    }
}
