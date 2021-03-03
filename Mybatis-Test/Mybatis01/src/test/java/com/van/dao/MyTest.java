package com.van.dao;

import com.van.pojo.Blog;
import com.van.pojo.SchoolClass;
import com.van.pojo.Teacher;
import com.van.utils.IDUtils;
import com.van.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

    @Test
    public void classTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SchoolClassMapper mapper = sqlSession.getMapper(SchoolClassMapper.class);
        List<SchoolClass> allStudent = mapper.getAllStudent();
        for (SchoolClass schoolClass : allStudent) {
            System.out.println(schoolClass);
        }
    }

    @Test
    public void getClassAndStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SchoolClassMapper mapper = sqlSession.getMapper(SchoolClassMapper.class);
        List<SchoolClass> classList = mapper.getClassAndStudent();
        for (SchoolClass schoolClass : classList) {
            System.out.println(schoolClass);
        }
    }

    @Test
    public void addBlogTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getID());
        blog.setAuthor("joe");
        blog.setTitle("php");
        blog.setCreateTime(new Date());
        blog.setViews(6666);
        int result = mapper.addBlog(blog);
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getBlogs(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String,String> map = new HashMap<String, String>();
        //map.put("author", "van");
        map.put("title", "hello");
        List<Blog> blogs = mapper.getBlogs(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void getBlogsChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("views", "9999");
        List<Blog> blogChoose = mapper.getBlogChoose(map);
        for (Blog blog : blogChoose) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("id", "ff42de0f50e3456c8e9b7a1ba400bd9c");
        map.put("author", "ben");
        int i = mapper.updateBlog(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getBlogForEach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<String> ids = new ArrayList<String>();
        ids.add("1c371e1793d44309920c7152d65ce00f");
        ids.add("2");
        map.put("ids", ids);
        List<Blog> blogsForeach = mapper.getBlogsForeach(map);
        for (Blog blog : blogsForeach) {
            System.out.println(blog);
        }
    }

    @Test
    public void cacheTest(){
        //一级缓存默认开启，在当前sqlSession中有效
        //增删改查会清空缓存
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacher(1);
        sqlSession.clearCache();//手动清理缓存
        System.out.println("============================");
        List<Teacher> teachers2 = mapper.getTeacher(2);
    }

    @Test
    public void cacheTestSecond() {
        //所有数据都会先放在一级缓存中，只有当会话提交或关闭时，才会提交到二级缓存中
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacher(1);
        sqlSession.close();

        System.out.println("============================");

        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        TeacherMapper mapper1 = sqlSession1.getMapper(TeacherMapper.class);
        List<Teacher> teachers1 = mapper1.getTeacher(1);
        sqlSession1.close();
    }
}
