package com.huang.controller;

import com.huang.pojo.User;
import com.huang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        userService.add(new User(4, "楚祎斐"));
        return "添加成功";
    }
    @RequestMapping("/query")
    @ResponseBody
    public String queryAll(){
        List<User> users=userService.queryAll();
        return users.toString();
    }
}
