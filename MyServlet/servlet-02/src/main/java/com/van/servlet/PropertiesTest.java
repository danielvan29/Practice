package com.van.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        InputStream input = this.getServletContext().getResourceAsStream("/WEB-INF/classes/first.properties");
        Properties properties = new Properties();
        properties.load(input);
        System.out.println(properties.getProperty("name"));
    }
}
