package com.huang.controller;

import com.huang.pojo.User;
import com.huang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//提供restful服务
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/discover")
    @ResponseBody
    //注册进来的微服务，获取一些信息，需要在主启动类开启才能用
    public Object discover(){
        //获取微服务列表清单
        List<String> services=client.getServices();
        System.out.println("微服务清单："+services);
        //得到一个具体的微服务id，applicationName，注意是大写
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDE");
        for (ServiceInstance instance:instances){
            System.out.println(instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()
            );
            // 微服务清单：[springcloud-provide]
            //10.210.136.42	8001	http://10.210.136.42:8001	SPRINGCLOUD-PROVIDE
        }
        return this.client;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        userService.add(new User(4, "楚祎斐"));
        return "添加成功";
    }
    @RequestMapping("/query")
    @ResponseBody
    public List<User> queryAll(){
        return userService.queryAll();
    }

}
