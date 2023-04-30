package com.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启Eureka，接收别人的注册
public class Eureka1 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka1.class,args);
    }
}
