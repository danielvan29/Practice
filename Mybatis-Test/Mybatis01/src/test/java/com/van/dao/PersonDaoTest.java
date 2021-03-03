package com.van.dao;

import com.van.pojo.Person;
import com.van.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDaoTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方法一
        PersonDao personDao = sqlSession.getMapper(PersonDao.class);
        List<Person> persons = personDao.getPersonList();

        //方法二
        //List<Person> persons = sqlSession.selectList("com.van.dao.PersonDao.getPersonList");

        for (Person person : persons) {
            System.out.println(person);
        }

        sqlSession.close();
    }

    @Test
    public void getPersonById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonDao personDao = sqlSession.getMapper(PersonDao.class);
        Person person = personDao.getPersonById("bob");
        System.out.println(person);
        sqlSession.close();
    }

    @Test
    public void getPersonLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonDao personDao = sqlSession.getMapper(PersonDao.class);
        List<Person> people = personDao.getPersonLike("%o%");
        for (Person person : people) {
            System.out.println(person);
        }
        sqlSession.close();
    }

    @Test
    public void addPerson() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonDao personDao = sqlSession.getMapper(PersonDao.class);
        int result = personDao.addPerson(new Person("dog",13));
        System.out.println(result);
        //增删改需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addPersonByMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name1", "pig");
        map.put("age1", 16);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonDao personDao = sqlSession.getMapper(PersonDao.class);
        personDao.addPersonByMap(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deletePerson() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonDao personDao = sqlSession.getMapper(PersonDao.class);
        personDao.deletePerson("dog");
        sqlSession.commit();
        sqlSession.close();
    }
}
