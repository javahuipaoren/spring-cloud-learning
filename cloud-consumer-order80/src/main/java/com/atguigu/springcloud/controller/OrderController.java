package com.atguigu.springcloud.controller;

import com.atguigu.cloud.api.entity.CommonResult;
import com.atguigu.cloud.api.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

//    private static String PROVIDER_URL = "http://localhost:8001";
    private static String PROVIDER_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/save")
    public CommonResult<Payment> savePayment(Payment payment) {
        return restTemplate.postForObject(PROVIDER_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PROVIDER_URL + "/payment/" + id, CommonResult.class);
    }
}
