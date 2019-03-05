package com.example.resttemplate.controller;

import com.example.resttemplate.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTemplateController {

    @Autowired
    RestTemplateService restTemplateService;

    @RequestMapping(value = "/world",method = RequestMethod.GET)
    public String world() {
        String result = restTemplateService.hiService("world");
        return "Return : " + result;
    }

}
