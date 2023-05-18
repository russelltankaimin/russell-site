package com.russellsite.russellsite.sayhelloapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "Hello This is Russell. I am learning Spring Boot!";
    }
}
