package com.venkat.albums.api.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class MyTokenController {

    @GetMapping
    public Map<String, Object> getToken(@AuthenticationPrincipal Jwt jwt) {
        //return jwt.getTokenValue();
        return Collections.singletonMap("pricipal", jwt);
    }
}
