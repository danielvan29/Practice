package com.van.dao.user;

import com.van.pojo.User;

import java.util.List;

public interface UserDao {

    User getLoginUser(String userCode, String password);

    int updatePassword(int id, String password);

    int getUserCount(String userName, int userRole);

    List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize);
}
