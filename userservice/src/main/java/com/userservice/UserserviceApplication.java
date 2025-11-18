package com.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        // Set timezone before Spring Boot starts
        System.setProperty("user.timezone", "UTC");
        SpringApplication.run(UserserviceApplication.class, args);
    }
}