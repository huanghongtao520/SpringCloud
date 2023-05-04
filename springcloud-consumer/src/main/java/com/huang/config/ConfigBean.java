package com.huang.config;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    //@Configuration -- spring  applicationContext.xml
    //配置负载均衡实现RestTemplate
    // IRule
    // RoundRobinRule 轮询
    // RandomRule 随机
    // AvailabilityFilteringRule ： 会先过滤掉，跳闸，访问故障的服务~，对剩下的进行轮询~
    // RetryRule ： 会先按照轮询获取服务~，如果服务获取失败，则会在指定的时间内进行，重试
    @Bean
    @LoadBalanced//Ribbon负载均衡,默认为轮询，每次刷新换一个服务提供者
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    //返回对象，使用官方定义的负载均衡对象，或者自定义的负载均衡对象
/*    @Bean
    public IRule myReule(){
        return new AvailabilityFilteringRule();//随机选择服务提供方
    }*/
}