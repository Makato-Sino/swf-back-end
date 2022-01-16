package com.sysu.swfbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@MapperScan("com.sysu.swfbackend.dao")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SwfBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwfBackEndApplication.class, args);
    }

}
