package com.van.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class DownServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String realName = "E:\\Project\\MyServlet\\response\\src\\main\\resources\\Jupiter.png";
        String fileName = realName.substring(realName.lastIndexOf("\\")+1);//从最后一个斜杠开始截取文件名
        FileInputStream in = new FileInputStream(realName);

        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode("测试.png","UTF-8"));

        byte[] buffer = new byte[1024];//缓冲区
        int len;

        ServletOutputStream out = resp.getOutputStream();
        while((len = in.read(buffer)) > 0){
            out.write(buffer,0,len);
        }

        in.close();
        out.flush();
        out.close();

    }
}
