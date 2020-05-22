package com.example.springboot_mybatis_mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.springboot_mybatis_mysql.mapper")
@SpringBootApplication
public class SpringbootMybatisMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisMysqlApplication.class, args);
    }
}
