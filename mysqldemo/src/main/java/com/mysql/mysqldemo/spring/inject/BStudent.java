package com.mysql.mysqldemo.spring.inject;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/27 22:14
 **/
@Service("b")
public class BStudent implements Student {
    @Override
    public void introduce() {
        System.out.println("rose");
    }
}
