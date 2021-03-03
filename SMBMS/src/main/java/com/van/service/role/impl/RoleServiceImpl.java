package com.van.service.role.impl;

import com.van.dao.role.RoleDao;
import com.van.dao.role.impl.RoleDaoImpl;
import com.van.pojo.Role;
import com.van.service.role.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Override
    public List<Role> getRoleList() {
        RoleDao roleDao = new RoleDaoImpl();
        List<Role> roleList = roleDao.getRoleList();
        return roleList;
    }
}
