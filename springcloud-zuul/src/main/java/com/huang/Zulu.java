package com.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启Zulu
public class Zulu {
    public static void main(String[] args) {
        SpringApplication.run(Zulu.class,args);
    }
}
