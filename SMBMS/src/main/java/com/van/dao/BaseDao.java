package com.van.dao;

import com.mysql.cj.protocol.Resultset;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        Properties properties = new Properties();
        InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");

        try {
            properties.load(inputStream);
            System.out.println("配置文件加载成功");
        } catch (IOException e) {
            System.out.println("配置文件加载失败");
        }

        driver = properties.getProperty("driver");
        System.out.println(driver);
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    //获取数据库链接
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        System.out.println("获取数据库连接");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    //查询
    public static ResultSet query(String sql,Object[] params) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        //设置sql参数
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
        return preparedStatement.executeQuery();
    }

    public static int update(String sql,Object[] params) throws SQLException, ClassNotFoundException {
        System.out.println("执行sql修改密码");
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        //设置sql参数
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
        int result = preparedStatement.executeUpdate();
        System.out.println(result);
        System.out.println("修改成功");
        return result;
    }

    public static void closeResource() {
        // TODO: 2020/11/22  
    }

}
