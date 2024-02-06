package com.venkat.dsl.springDsl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping   //http://localhost/home
    public String sayHello(){
        return "Hello, Venkatram";
    }
}
