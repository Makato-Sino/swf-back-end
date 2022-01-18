package com.sysu.swfbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//exclude = {
//        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
//        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
//        }

//@MapperScan("com.sysu.swfbackend.mapper")
@MapperScan("com.sysu.swfbackend.dao")
@SpringBootApplication()
public class SwfBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwfBackEndApplication.class, args);
    }

}
