package com.van.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("count");

        if (count == null){
            count = new Integer(1);
        }else{
            count++;
        }

        System.out.println("create");
        context.setAttribute("count",count);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("count");

        if (count == null){
            count = new Integer(0);
        }else{
            count--;
        }

        System.out.println("destroy");
        context.setAttribute("count",count);
    }
}
