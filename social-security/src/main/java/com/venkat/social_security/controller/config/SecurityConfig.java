package com.venkat.social_security.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(request ->
                request.requestMatchers("/secure")
                        .authenticated()
                        .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults());
        return httpSecurity.build();
    }

    //if properties are created in application.properties there is no need to write below code

    /*@Bean
    ClientRegistrationRepository clientRegistrationRepository(){
        return new InMemoryClientRegistrationRepository(githubClientRegistration(), facebookClientRegistration());
    }

    private ClientRegistration githubClientRegistration(){
        return CommonOAuth2Provider.GITHUB
                .getBuilder("github")
                .clientId("")
                .clientSecret("")
                .build();
    }

    private ClientRegistration facebookClientRegistration(){
        return CommonOAuth2Provider.FACEBOOK
                .getBuilder("facebook")
                .clientId("")
                .clientSecret("")
                .build();
    }*/
}
