package com.van.dao;

import com.van.pojo.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface AccountMapper {
    List<Account> getAccounts();

    List<Account> getAccountsByLimit(Map<String, Integer> map);

    @Select("select * from test.account where id = #{id}")
    //如果sql有多个参数，参数前要添加Param注解
    Account getAccountById(int id);
}
