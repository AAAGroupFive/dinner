package com.dinner;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * className:SpringBootMainApp
 * describe:
 * author:邢芳彬
 * createTime:2018-11-09 14:02
 */
@SpringBootApplication
@MapperScan("com.xfb.sm.dao")
public class SpringBootMainApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainApp.class);
    }
}
