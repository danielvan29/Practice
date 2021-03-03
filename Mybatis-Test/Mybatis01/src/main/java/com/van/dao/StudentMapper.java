package com.van.dao;

import com.van.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudents();

    List<Student> getStudentJoin();
}
