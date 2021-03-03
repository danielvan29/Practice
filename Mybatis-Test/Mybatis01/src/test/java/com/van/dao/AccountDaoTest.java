package com.van.dao;

import com.van.pojo.Account;
import com.van.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class AccountDaoTest {

    static Logger logger = Logger.getLogger(AccountDaoTest.class);

    @Test
    public void getAccounts() {
        logger.info("获取account");
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> accounts = accountMapper.getAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
        sqlSession.close();
    }

    @Test
    public void getAccountsByLimit() {
        logger.info("分页获取account");
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        HashMap<String, Integer> map = new HashMap();
        map.put("pageSize", 3);
        map.put("startIndex", 0);
        List<Account> accounts = accountMapper.getAccountsByLimit(map);
        for (Account account : accounts) {
            System.out.println(account);
        }
        sqlSession.close();
    }

    @Test
    public void getAccountsById() {
        logger.info("根据获取account");
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        Account account = accountMapper.getAccountById(1);
        System.out.println(account);
        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.info("info");
        logger.error("error");
        logger.debug("debug");
    }
}
