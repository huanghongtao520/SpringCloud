package com.huang.controller;

import com.huang.pojo.User;
import com.huang.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class UserConsumerController {

    @Autowired  //若提示没有bean，则在springcloud-api中uesrClient添加Component注解
    private UserClientService userClientService;

    @RequestMapping("/query/{id}")
    @ResponseBody  //注意远程请求返回的格式，若是String格式，则无法转为User
    public User query(@PathVariable("id") int id){
        return userClientService.queryById(id);
    }
    @RequestMapping("/query")
    @ResponseBody  //注意远程请求返回的格式，若是String格式，则无法转为User
    public List<User> query1(){
        return userClientService.query();
    }
}
