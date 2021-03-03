package com.van.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.van.pojo.Role;
import com.van.pojo.User;
import com.van.service.role.RoleService;
import com.van.service.role.impl.RoleServiceImpl;
import com.van.service.user.UserService;
import com.van.service.user.impl.UserServiceImpl;
import com.van.util.Constants;
import com.van.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String method = req.getParameter("method");
        /*if (method.equals("savepwd")) {
            this.updatePassword(req, resp);
        } else if (method.equals("pwdmodify")){
            this.pwdModify(req, resp);
        } else if (method.equals("query")) {

        }*/
        switch (method) {
            case "savepwd":
                System.out.println("savepwd");
                this.updatePassword(req, resp);
                break;
            case "pwdmodify":
                System.out.println("pwdmodify");
                this.pwdModify(req, resp);
                break;
            case "query":
                System.out.println("query");
                this.query(req, resp);
                break;
            default:
                System.out.println("非法请求");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }

    public void updatePassword(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);
        String newPassword = req.getParameter("newpassword");
        System.out.println("new password:"+newPassword);

        if (user != null && newPassword != null) {
            UserService userService = new UserServiceImpl();
            if (userService.updatePassword(user.getId(), newPassword)) {
                req.setAttribute("message", "密码修改成功");
                req.getSession().removeAttribute(Constants.USER_SESSION);
            } else {
                req.setAttribute("message", "密码修改失败");
            }
        } else {
            req.setAttribute("message", "新密码有误");
        }

        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pwdModify(HttpServletRequest req, HttpServletResponse resp){
        User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);
        String oldPassword = req.getParameter("oldpassword");
        Map<String, String> resultMap = new HashMap<>();

        if (user == null) {
            System.out.println("sessionerror");
            resultMap.put("result","sessionerror");
        } else if (oldPassword == null) {
            System.out.println("error");
            resultMap.put("result", "error");
        } else {
            String userPassword = user.getUserPassword();
            if (oldPassword.equals(userPassword)) {
                System.out.println("true");
                resultMap.put("result", "true");
            } else {
                System.out.println("false");
                resultMap.put("result", "false");
            }
        }

        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            //阿里巴巴的JSON工具类，转换格式
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void query(HttpServletRequest req, HttpServletResponse resp){
        UserService userService = new UserServiceImpl();

        String queryUserName = req.getParameter("queryname");
        String tempUserRole = req.getParameter("queryUserRole");
        int userRole = 0;
        String pageIndex = req.getParameter("pageIndex");

        int pageSize = 5;
        int currentPageNo = 1;

        /*if (queryUserName == null) {
            queryUserName = "";
        }*/
        if (tempUserRole != null) {
            userRole = Integer.parseInt(tempUserRole);
        }
        if (pageIndex != null) {
            currentPageNo = Integer.parseInt(pageIndex);
        }

        System.out.println("获取用户总数");
        int totalCount = userService.getUserCount(queryUserName, userRole);
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);

        int totalPageCount = totalCount/pageSize + 1;

        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }

        List<User> userList = userService.getUserList(queryUserName, userRole, currentPageNo, pageSize);
        req.setAttribute("userList", userList);

        RoleService roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        req.setAttribute("roleList", roleList);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);
        req.setAttribute("queryUserName", queryUserName);
        req.setAttribute("userRole", userRole);
        req.setAttribute("totalPageCount", totalPageCount);

        try {
            req.getRequestDispatcher("userlist.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
