package com.van.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        //启动web服务器，创建过滤器
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        chain.doFilter(request,response);//请求继续往下走
    }

    public void destroy() {
        //关闭web服务器，销毁过滤器
    }
}
