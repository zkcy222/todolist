package com.example.todolistserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.example.todolistserver.dao")
public class TodolistserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodolistserverApplication.class, args);
    }
}
