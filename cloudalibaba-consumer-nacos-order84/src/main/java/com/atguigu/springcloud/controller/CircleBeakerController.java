package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloud.api.entity.CommonResult;
import com.atguigu.cloud.api.entity.Payment;
import com.atguigu.springcloud.service.PaymentFeign84Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircleBeakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentFeign84Service feignService;

    //触发顺序：blockHandler -> fallback
    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockFallback", exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id") Integer id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/payment/nacos/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("argument exception!");
        } else if (result.getData() == null) {
            throw new NullPointerException("data is null!");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable Long id, Throwable e) {
        return new CommonResult<>(444, "兜底异常handlerFallback:" + e.getMessage(), new Payment(id, null));
    }

    public CommonResult<Payment> blockFallback(@PathVariable Long id, BlockException blockException) {
        return new CommonResult<>(445, "blockException fallback:" + blockException.getMessage(), new Payment(id, null));
    }

    @GetMapping("/consumer/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
        return feignService.paymentSql(id);
    }
}
