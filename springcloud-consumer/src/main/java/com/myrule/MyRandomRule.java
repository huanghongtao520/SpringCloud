
package com.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
// 自定义负载均衡算法作用：每个服务访问5次，切换下一个
public class MyRandomRule extends AbstractLoadBalancerRule {

    //被调用次数
    private int total=0;
    //当前是哪个服务
    private int currentIndex=0;

    public MyRandomRule() {
    }

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(true) {
                if (Thread.interrupted()) {
                    return null;
                }
                // 获取全部活着的服务
                List<Server> upList = lb.getReachableServers();
                // 获取全部的服务
                List<Server> allList = lb.getAllServers();

                // 获取全部服务数量
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                //自定义算法,每个服务调用5次，切换下一个
                if (total<5){
                    server=upList.get(currentIndex);
                    total++;
                }else {
                    total=0;
                    currentIndex++;
                    if (currentIndex>upList.size()){
                        currentIndex=0;
                    }
                    server=upList.get(currentIndex);
                }

                if (server == null) {
                    Thread.yield(); //线程礼让
                } else {
                    if (server.isAlive()) {
                        return server;
                    }
                    server = null;
                    Thread.yield();
                }
            }

        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
