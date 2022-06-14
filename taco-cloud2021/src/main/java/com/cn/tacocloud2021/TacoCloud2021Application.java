package com.cn.tacocloud2021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TacoCloud2021Application {
    public static void main(String[] args) {
        SpringApplication.run(TacoCloud2021Application.class, args);
    }
}
