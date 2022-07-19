package com.mysql.mysqldemo.mysql;

import com.mysql.mysqldemo.entity.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> findPersonList();

    Person findOne(Integer id);

    int save(Person person);

    int delete(Integer id);
}
