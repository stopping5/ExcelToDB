package com.stopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.stopping.mvc.dao")
public class ExcelToDBApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExcelToDBApplication.class,args);
    }
}
