package huang.controller;

import com.huang.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import huang.service.UserService;
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

    @HystrixCommand(fallbackMethod = "queryHystrix")//失败后调用的方法
    @RequestMapping("/query/{id}")
    @ResponseBody
    public User queryAll(@PathVariable("id") int id){
        User user = userService.queryById(id);
        if (user==null)
            throw new RuntimeException("id:"+id+"，用户未找到");
        return user;
    }

    //服务崩溃后备选方法,不能直接放在上面，请求一般失败很多次才调用备选方法
    public User queryHystrix(@PathVariable("id") int id){
        return new User()
                .setId(id)
                .setName("发生错误，用户未找到")
                .setDb_source("没有这个数据库");
        // 最后测试ID为5输出 {"id":5,"name":"发生错误，用户未找到","db_source":"没有这个数据库"}
    }

}
