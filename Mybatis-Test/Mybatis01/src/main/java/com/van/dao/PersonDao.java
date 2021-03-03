package com.van.dao;

import com.van.pojo.Person;

import java.util.List;
import java.util.Map;

public interface PersonDao {
    List<Person> getPersonList();

    Person getPersonById(String name);

    List<Person> getPersonLike(String value);

    int addPerson(Person person);

    int addPersonByMap(Map<String,Object> map);

    int deletePerson(String name);
}
