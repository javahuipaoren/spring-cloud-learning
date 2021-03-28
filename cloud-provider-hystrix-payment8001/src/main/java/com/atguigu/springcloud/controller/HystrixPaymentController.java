package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.HystrixPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HystrixPaymentController {

    @Autowired
    private HystrixPaymentService hystrixPaymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        String result = hystrixPaymentService.paymentInfoOK(id);
        log.info("*****result: {}", result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = hystrixPaymentService.paymentInfoTimeout(id);
        log.info("*****result: {}", result);
        return result;
    }
}
