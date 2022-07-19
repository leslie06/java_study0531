package com.mysql.mysqldemo.mysql;

import com.mysql.mysqldemo.entity.People;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaPersonRepository extends CrudRepository<People,Long> {
    @Query("select p from com.mysql.mysqldemo.entity.People p where p.name = :name")
    People findByName(@Param("name") String name);
    @Query("select p from com.mysql.mysqldemo.entity.People p")
    List<People>findAll();
}
