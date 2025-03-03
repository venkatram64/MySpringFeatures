package com.venkat.social_security.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
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

    @Bean
    ClientRegistrationRepository clientRegistrationRepository(){
        return new InMemoryClientRegistrationRepository(githubClientRegistration(), facebookClientRegistration());
    }

    private ClientRegistration githubClientRegistration(){
        return CommonOAuth2Provider.GITHUB
                .getBuilder("github")
                .clientId("Ov23liXYvg2icDMawFo1")
                .clientSecret("2cff7bf381cd7cfb2a78351fa65f642bd3d711e0")
                .build();
    }

    private ClientRegistration facebookClientRegistration(){
        return CommonOAuth2Provider.FACEBOOK
                .getBuilder("facebook")
                .clientId("530445723218937")
                .clientSecret("f94474342f91b44775194a502b4fcf9a")
                .build();
    }
}
