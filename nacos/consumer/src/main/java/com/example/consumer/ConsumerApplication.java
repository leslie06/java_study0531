package com.example.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
@RequestMapping("/consumer")
public class ConsumerApplication {
    @Autowired
    private ProvideFeign provideFeign;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
    @RequestMapping("/hi")
    public String hi(){
        return provideFeign.hello();
    }

}
