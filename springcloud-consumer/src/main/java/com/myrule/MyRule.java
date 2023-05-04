package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//注意： 这个类不应该放在主启动类的可以扫描的包下，应该单独一个包。
@Configuration
public class MyRule {
    @Bean
    public IRule myReule(){
        return new MyRandomRule();//自定义的负载均衡算法。
    }
}
