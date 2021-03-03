package com.van.service.user;

import com.van.pojo.User;

import java.util.List;

public interface UserService {
    User userLogin(String userCode, String password);

    boolean updatePassword(int id, String password);

    int getUserCount(String userName, int userRole);

    List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize);
}
