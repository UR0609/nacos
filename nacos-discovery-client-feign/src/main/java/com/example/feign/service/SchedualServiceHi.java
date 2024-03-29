package com.example.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("nacos-discovery-server")
public interface SchedualServiceHi {

    @GetMapping("/hello")
    String hello(@RequestParam(name = "name") String name);

}
