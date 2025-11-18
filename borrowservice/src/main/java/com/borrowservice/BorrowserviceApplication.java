package com.borrowservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BorrowserviceApplication {

    public static void main(String[] args) {
        // Set timezone to UTC
        System.setProperty("user.timezone", "UTC");
        SpringApplication.run(BorrowserviceApplication.class, args);
    }
}