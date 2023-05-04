package com.huang.service;

import com.huang.pojo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

//服务降级
@Component
public class UserClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public UserClientService create(Throwable throwable) {
        return new UserClientService() {
            //服务降级，关闭通过ID查询用户服务
            @Override
            public User queryById(int id) {
                return new User()
                        .setId(id)
                        .setName("服务降级，客户端提供了降级服务，这个服务已经关闭")
                        .setDb_source("没有这个数据库");
            }
            //输出 {"id":1,"name":"服务降级，客户端提供了降级服务，这个服务已经关闭","db_source":"没有这个数据库"}

            @Override
            public List<User> query() {
                return null;
            }


        };
    }
}
