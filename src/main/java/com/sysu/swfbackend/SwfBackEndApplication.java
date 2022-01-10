package com.sysu.swfbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.sysu.swfbackend.dao")
@SpringBootApplication
public class SwfBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwfBackEndApplication.class, args);
    }

}
