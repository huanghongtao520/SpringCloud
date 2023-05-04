package com.huang;

import com.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//微服务启动的时候加载我们自定义的Ribbon负载均衡算法
//@RibbonClient(value = "SPRINGCLOUD-PROVIDE",configuration = MyRule.class)
public class Consumer {
    public static void main(String[] args) {
        SpringApplication.run(Consumer.class,args);
    }
}
