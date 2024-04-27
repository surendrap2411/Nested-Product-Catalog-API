package com.example.LedToRevDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.LedToRevDemo", "com.example.LedToRevDemo.Repository"})
@SpringBootApplication
public class LedToRevDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LedToRevDemoApplication.class, args);
    }

}
