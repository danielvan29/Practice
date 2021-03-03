package com.van.dao.user.impl;

import com.van.dao.BaseDao;
import com.van.dao.user.UserDao;
import com.van.pojo.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {


    public User getLoginUser(String userCode,String password) {
        User user = null;
        ResultSet resultSet;
        String sql = "select * from smbms_user where userCode=?";
        System.out.println("userCode:" + userCode);
        Object[] params = {userCode};

        try {
            resultSet = BaseDao.query(sql, params);
            System.out.println("返回成功");
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserCode(resultSet.getString("userCode"));
                user.setUserName(resultSet.getString("userName"));
                user.setUserPassword(resultSet.getString("userPassword"));
                user.setGender(resultSet.getInt("gender"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setPhone(resultSet.getString("phone"));
                user.setAddress(resultSet.getString("address"));
                user.setUserRole(resultSet.getInt("userRole"));
                user.setCreatedBy(resultSet.getInt("createdBy"));
                user.setCreationDate(resultSet.getTimestamp("creationDate"));
                user.setModifyBy(resultSet.getInt("modifyBy"));
                user.setModifyDate(resultSet.getTimestamp("modifyDate"));
                if (!user.getUserPassword().equals(password)) {
                    System.out.println("密码错误");
                    return null;
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("查询用户失败");
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        return user;
    }

    public int updatePassword(int id, String password) {
        System.out.println("修改密码");
        String sql = "update smbms_user set userPassword = ? where id = ?";
        Object[] params = {password, id};
        int result = 0;
        try {
            result = BaseDao.update(sql, params);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println(1);
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
            System.out.println(2);
        }
        return result;
    }

    public int getUserCount(String userName, int userRole) {
        int count = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole = r.id");
        ArrayList<Object> list = new ArrayList<>();//存放参数
        if (userName != null) {
            sql.append(" and u.userName like ?");
            list.add("%" + userName + "%");
        }
        if (userRole > 0) {
            sql.append(" and u.userRole = ?");
            list.add(userRole);
        }
        System.out.println("sql:" + sql);
        Object[] params = list.toArray();

        try {
            ResultSet resultSet = BaseDao.query(sql.toString(), params);
            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return count;
    }

    public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize) {
        StringBuilder sql = new StringBuilder("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
        List<Object> list = new ArrayList<>();
        List<User> userList = new ArrayList<>();

        if (userName != null) {
            sql.append(" and u.userName like ?");
            list.add("%" + userName + "%");
        }
        if (userRole > 0) {
            sql.append(" and u.userRole = ?");
            list.add(userRole);
        }
        sql.append(" order by u.creationDate desc limit ?,?");
        int lastPageNo = (currentPageNo - 1) * pageSize;
        list.add(lastPageNo);
        list.add(pageSize);
        Object[] params = list.toArray();
        try {
            ResultSet resultSet = BaseDao.query(sql.toString(), params);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserCode(resultSet.getString("userCode"));
                user.setUserName(resultSet.getString("userName"));
                user.setGender(resultSet.getInt("gender"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setPhone(resultSet.getString("phone"));
                user.setUserRole(resultSet.getInt("userRole"));
                user.setUserRoleName(resultSet.getString("userRoleName"));
                userList.add(user);
            }
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return userList;
    }

}
