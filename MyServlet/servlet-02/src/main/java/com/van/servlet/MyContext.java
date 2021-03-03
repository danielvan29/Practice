package com.van.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyContext extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext con = this.getServletContext();
        con.setAttribute("test",555);

        resp.setContentType("text/html;charset=utf-8");
        //resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("去你妈的");
    }


}
