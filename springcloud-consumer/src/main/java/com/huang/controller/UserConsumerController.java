package com.huang.controller;

import com.huang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class UserConsumerController {
    //RestTemplate提供多种便捷访问远程http服务的方法，简单的RestFul服务模版
    //RestTemplate .. 直接调用，注册到Spring中

    //RestTemplate参数（url,实体：map,Class<T> responseType）
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX="http://localhost:8001";

    @RequestMapping("/query")
    @ResponseBody  //注意远程请求返回的格式，若是String格式，则无法转为User
    public List<User> query(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/query",List.class);
    }
}
