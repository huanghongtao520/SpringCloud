package com.huang.service;

import com.huang.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Fegin ,fallback指定熔断降级服务
@FeignClient(value = "SPRINGCLOUD-PROVIDE",fallbackFactory = UserClientServiceFallbackFactory.class)
public interface UserClientService {
    @GetMapping("/query")
    public List<User> query();

    @GetMapping("/query/{id}")
    public User queryById(@PathVariable("id") int id);
}
