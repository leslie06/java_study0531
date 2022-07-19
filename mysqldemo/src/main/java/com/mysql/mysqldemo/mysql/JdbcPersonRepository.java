package com.mysql.mysqldemo.mysql;

import com.mysql.mysqldemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description 通过jdbcTemplate操作数据库
 * @Author leslie
 * @Date 2022/7/19 18:26
 **/
@Repository
public class JdbcPersonRepository implements PersonRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Person> findPersonList() {
//        return jdbcTemplate.query("select id,name,age,gender,city from person",
//                this::mapRowToPerson);
        String sql = "select id,name,age,gender,city from person";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<Person>(Person.class);
        List<Person> personList = jdbcTemplate.query(sql, rowMapper);
        return personList;
    }

    @Override
    public Person findOne(Integer id) {
//        return jdbcTemplate.queryForObject("select id,name,age,gender,city from person where id = ?",
//                this::mapRowToPerson,id);
        String sql = "select id,name,age,gender,city from person where id = ?";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<Person>(Person.class);
        Person person = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return person;
    }

    @Override
    public int save(Person person) {
        return jdbcTemplate.update("insert into person(id,name,age,gender,city) values(?,?,?,?,?)",
                person.getId(),
                person.getName(),
                person.getAge(),
                person.getGender(),
                person.getCity());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("delete from person where id = ?",id);
    }

    private Person mapRowToPerson(ResultSet rs,int rowNum) throws SQLException {
        return new Person(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("gender"),
                rs.getString("city")
        );
    }
}
