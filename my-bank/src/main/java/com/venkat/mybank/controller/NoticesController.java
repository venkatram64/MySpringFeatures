package com.venkat.mybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notices")
public class NoticesController {

    @GetMapping
    public String getNoticesDetails(){
        return "notices details";
    }
}
