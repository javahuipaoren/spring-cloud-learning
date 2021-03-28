package com.atguigu.springcloud.service;

import com.atguigu.cloud.api.entity.CommonResult;
import com.atguigu.cloud.api.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value="/payment/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    //超时测试
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
