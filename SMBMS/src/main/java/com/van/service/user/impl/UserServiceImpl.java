package com.van.service.user.impl;

import com.van.dao.user.UserDao;
import com.van.dao.user.impl.UserDaoImpl;
import com.van.pojo.User;
import com.van.service.user.UserService;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    public User userLogin(String userCode, String password) {
        User user = userDao.getLoginUser(userCode, password);
        return user;
    }

    public boolean updatePassword(int id, String password) {
        if (userDao.updatePassword(id, password) > 0) {
            System.out.println("return true");
            return true;
        }
        System.out.println("return false");
        return false;
    }

    public int getUserCount(String userName, int userRole) {
        int count = userDao.getUserCount(userName, userRole);
        return count;
    }

    public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize) {
        List<User> userList = userDao.getUserList(userName, userRole, currentPageNo, pageSize);
        return userList;
    }

    @Test
    public void test() {
        //User user = userLogin("admin", "1234567");
        //System.out.println(user.getUserCode());

        //System.out.println("user count:" + getUserCount(null,2));
    }
}
