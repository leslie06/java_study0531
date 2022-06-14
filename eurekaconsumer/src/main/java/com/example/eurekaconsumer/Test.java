package com.example.eurekaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/14 16:24
 **/
@RestController
public class Test {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/test")
    public String test(){
        String result = restTemplate.getForObject("http://service-provider/test",String.class);
        return result;
    }
}
