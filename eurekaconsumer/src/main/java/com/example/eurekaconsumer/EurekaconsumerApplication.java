package com.example.eurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EurekaconsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaconsumerApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate rest(){
        return new RestTemplate();
    }

}
