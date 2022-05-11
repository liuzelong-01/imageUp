package com.lzl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan(basePackages = "com.lzl.mapper")
public class ImageUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageUpApplication.class, args);
    }

}
