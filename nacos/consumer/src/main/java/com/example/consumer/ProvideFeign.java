package com.example.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="provide")
public interface ProvideFeign {
    @RequestMapping("/provide/hello")
    public String hello();
}
