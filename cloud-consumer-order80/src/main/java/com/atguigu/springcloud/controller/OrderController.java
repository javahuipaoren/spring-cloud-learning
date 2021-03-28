package com.atguigu.springcloud.controller;

import com.atguigu.cloud.api.entity.CommonResult;
import com.atguigu.cloud.api.entity.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class OrderController {

//    private static String PROVIDER_URL = "http://localhost:8001";
    private static String PROVIDER_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/save")
    public CommonResult<Payment> savePayment(Payment payment) {
        return restTemplate.postForObject(PROVIDER_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PROVIDER_URL + "/payment/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentByLb() {
        // 通过容器中的 discoveryClient和服务名来获取服务集群
        List<ServiceInstance> listInstance = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (listInstance == null || listInstance.size() == 0) {
            return null;
        }
        // 传入服务集群来计算出获取具体的服务实例
        ServiceInstance serviceInstance = loadBalancer.instances(listInstance);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
