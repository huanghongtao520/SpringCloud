package huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//主启动类
@SpringBootApplication
@EnableEurekaClient //启动Eureka客户端，注册到Eureka中
@EnableDiscoveryClient //服务发现
public class SpringCloud_Provide8002 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloud_Provide8002.class,args);
    }
}
