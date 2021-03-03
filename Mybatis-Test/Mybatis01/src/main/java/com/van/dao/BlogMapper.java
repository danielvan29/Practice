package com.van.dao;

import com.van.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);

    List<Blog> getBlogs(Map map);

    List<Blog> getBlogChoose(Map map);

    int updateBlog(Map map);

    List<Blog> getBlogsForeach(Map map);
}
