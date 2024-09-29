package com.venkat.social_security.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MySecureController {

    @GetMapping("/secure")
    public String securePage(Authentication authentication){
        if(authentication instanceof UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken){
            System.out.printf(usernamePasswordAuthenticationToken.toString());
        }else if(authentication instanceof OAuth2AuthenticationToken oAuth2AuthenticationToken){
            System.out.printf(oAuth2AuthenticationToken.toString());
        }
        return "secure.html";
    }
}
