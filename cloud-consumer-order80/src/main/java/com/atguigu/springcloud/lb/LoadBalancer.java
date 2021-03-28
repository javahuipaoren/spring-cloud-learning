package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {

    //负载均衡轮询算法，rest接口第几次请求数 % 服务器集群总数 = 实际调用服务器位置下标
    ServiceInstance instances(List<ServiceInstance> instanceList);
}
