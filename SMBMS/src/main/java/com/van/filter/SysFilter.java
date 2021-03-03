package com.van.filter;

import com.van.pojo.User;
import com.van.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        User user = (User) httpServletRequest.getSession().getAttribute(Constants.USER_SESSION);

        if (user == null) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/error.jsp");
        } else {
            chain.doFilter(request,response);
        }
    }

    public void destroy() {

    }
}
