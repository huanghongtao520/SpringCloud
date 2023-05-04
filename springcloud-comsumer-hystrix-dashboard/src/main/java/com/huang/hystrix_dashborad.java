package com.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启监控页面
public class hystrix_dashborad {
    public static void main(String[] args) {
        SpringApplication.run(hystrix_dashborad.class,args);
    }
}
