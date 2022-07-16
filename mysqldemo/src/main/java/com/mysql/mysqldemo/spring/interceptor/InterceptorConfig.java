package com.mysql.mysqldemo.spring.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/16 20:50
 **/
@Component
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private LogCostInterceptor logCostInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logCostInterceptor).addPathPatterns("/**");
    }
}
