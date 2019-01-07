package com.example.springtestdemo.controller;

import com.example.springtestdemo.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SampleController {
    Logger logger = LoggerFactory.getLogger(SampleController.class);
    @Autowired
    private SampleService samplService;

    @GetMapping("/hello")
    public String hello(){
        logger.info("055055");
        System.out.println("가급적쓰지말기");
        return "hello!" + samplService.getName();
    }
}
