package com.mysql.mysqldemo;

import com.mysql.mysqldemo.entity.People;
import com.mysql.mysqldemo.entity.Person;
import com.mysql.mysqldemo.entity.User;
import com.mysql.mysqldemo.mysql.JpaPersonRepository;
import com.mysql.mysqldemo.mysql.PersonRepository;
import com.mysql.mysqldemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class MysqldemoApplicationTests {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private JpaPersonRepository jpaPersonRepository;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void testAdd() {
        Person person = new Person();
        person.setId(5);
        person.setName("小红");
        person.setAge(18);
        person.setGender("女");
        person.setCity("南京");
        personRepository.save(person);
        System.out.println("插入成功");
        System.out.println(person);
    }
    @Test
    void findPersonListTest(){
        List<Person>personList = personRepository.findPersonList();
        System.out.println(personList);

    }
    @Test
    void finOneTest(){
        Person person = personRepository.findOne(1);
        System.out.println(person);

    }
    @Test
    void deleteTest(){
        personRepository.delete(5);
        System.out.println("删除成功");
    }

    //springdata jpa测试
    @Test
    void findByName(){
        People people = jpaPersonRepository.findByName("李清照");
        System.out.println(people);
    }
    @Test
    void findAll(){
        List<People> list = jpaPersonRepository.findAll();
        System.out.println(list);
    }
    @Test
    void register(){
        User user = new User();
        user.setName("康昱");
        user.setPassword("88888888");
        userService.register(user);
        System.out.println(userService.register(user));
    }
    @Test
    void login(){
        User user = new User();
        user.setName("康昱");
        user.setPassword("888888889");
        userService.login(user);
        System.out.println(userService.login(user));
    }



}
