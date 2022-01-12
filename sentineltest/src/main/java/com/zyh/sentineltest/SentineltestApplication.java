package com.zyh.sentineltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SentineltestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentineltestApplication.class, args);
    }

}
