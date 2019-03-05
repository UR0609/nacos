package com.example.resttemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    public String hiService(String name) {
        String result = restTemplate.getForObject("http://nacos-discovery-server/hello?name="+name, String.class);
        return result;
    }

}
