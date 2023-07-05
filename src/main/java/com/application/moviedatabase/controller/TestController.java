package com.application.moviedatabase.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("test")
public class TestController {

    @GetMapping("/hello")
    public String getGello() {
        return "Hello";
    }
}
