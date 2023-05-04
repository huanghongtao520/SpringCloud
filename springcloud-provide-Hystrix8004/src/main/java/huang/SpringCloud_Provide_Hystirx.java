package huang;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

//主启动类
@SpringBootApplication
@EnableEurekaClient //启动Eureka客户端，注册到Eureka中
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker //添加对Hystirx熔断支持
public class SpringCloud_Provide_Hystirx {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloud_Provide_Hystirx.class,args);
    }
    //增加一个servlet,配合监控使用

    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean servletRegistrationBean =
                new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream");
        return servletRegistrationBean;
    }
}
