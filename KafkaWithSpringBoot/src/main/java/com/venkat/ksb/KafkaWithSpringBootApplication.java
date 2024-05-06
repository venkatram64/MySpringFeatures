package com.venkat.ksb;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaWithSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaWithSpringBootApplication.class, args);
    }

    @Bean
    public Faker faker(){
        return new Faker();
    }
}