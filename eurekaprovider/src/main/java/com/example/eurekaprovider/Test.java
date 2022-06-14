package com.example.eurekaprovider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/14 15:38
 **/
@RestController
public class Test {
    @RequestMapping("/test")
    public String get(){
        return "hello world!";
    }
}
