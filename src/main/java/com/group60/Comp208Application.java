package com.group60;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.group60.dao")
public class Comp208Application {

    public static void main(String[] args) {
        SpringApplication.run(Comp208Application.class, args);
    }

}
