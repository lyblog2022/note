package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ProductApplication
 *
 * @author liuyong
 * @version 1.0
 * @description com
 * @date 2022/6/25 15:58
 */
@SpringBootApplication
@MapperScan("com.mapper")
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class , args);
    }
}
