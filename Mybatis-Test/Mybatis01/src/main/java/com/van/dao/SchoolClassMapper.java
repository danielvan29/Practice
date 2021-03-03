package com.van.dao;

import com.van.pojo.SchoolClass;

import java.util.List;

public interface SchoolClassMapper {
    List<SchoolClass> getSchoolClass();

    List<SchoolClass> getAllStudent();

    List<SchoolClass> getClassAndStudent();
}
