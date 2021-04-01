package com.atguigu.springcloud.service;

import com.atguigu.cloud.api.entity.CommonResult;
import com.atguigu.cloud.api.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider", fallback = PaymentFeign84FallbackService.class)
public interface PaymentFeign84Service {

    @GetMapping("/payment/nacos/{id}")
    CommonResult<Payment> paymentSql(@PathVariable("id") Long id) ;
}
