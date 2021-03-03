package com.van.dao.role.impl;

import com.van.dao.BaseDao;
import com.van.dao.role.RoleDao;
import com.van.pojo.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @Override
    public List<Role> getRoleList() {
        List<Role> roleList = new ArrayList<>();
        ResultSet resultSet = null;
        String sql = "select * from smbms_role";
        Object[] params = {} ;
        try {
            resultSet =BaseDao.query(sql,params);
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setRoleCode(resultSet.getString("roleCode"));
                role.setRoleName(resultSet.getString("roleName"));
                roleList.add(role);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        return roleList;
    }
}
