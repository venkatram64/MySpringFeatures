package com.venkat.multi.springMultiConfig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home(){
        return "Hello, Venkatram";
    }

    @GetMapping("/private")
    public String secure(){
        return "secured...";
    }
}
