package com.van.dao;

import com.van.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacher(int id);
}
