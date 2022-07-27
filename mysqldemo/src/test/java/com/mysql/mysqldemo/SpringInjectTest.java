package com.mysql.mysqldemo;

import com.mysql.mysqldemo.spring.inject.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @Description 两个类实现同一个接口，用@Resource区分两个bean，否则注入失败
 * @Author leslie
 * @Date 2022/7/27 22:14
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringInjectTest {
    @Resource(name = "b")
    private Student student;
    @Test
    public void test(){
        student.introduce();
    }

}
