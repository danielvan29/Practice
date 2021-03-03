package com.van.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        //resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if (cookies == null){
            System.out.println("no");
            out.print("没有cookie");
        } else {
            System.out.println("yes");
            for (int i = 0 ; i < cookies.length ; i++){
                if (cookies[i].getName().equals("time")){
                    Date date = new Date(Long.parseLong(cookies[i].getValue()));
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    out.print("上次登录时间：" + simpleDateFormat.format(date));
                }
            }
        }

        Cookie c = new Cookie("time",Long.toString(System.currentTimeMillis()));
        c.setMaxAge(100);//设置cookie的有效期
        resp.addCookie(c);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
