package com.hxb.demo10;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hxb.demo10.mapper")
public class Demo10Application {

    public static void main(String[] args) {

        SpringApplication.run(Demo10Application.class, args);
    }




}
