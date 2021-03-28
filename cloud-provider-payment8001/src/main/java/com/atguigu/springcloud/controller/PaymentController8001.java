package com.atguigu.springcloud.controller;

import com.atguigu.cloud.api.entity.CommonResult;
import com.atguigu.cloud.api.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController8001 {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult<Payment> createPayment(@RequestBody Payment payment) {
      int rows = paymentService.save(payment);
      if (rows > 0) {
          return new CommonResult(200, "success, serverPort:" + serverPort, rows);
      } else {
          log.info("create payment failed, payment:{}", payment);
          return new CommonResult(444, "fail, serverPort:" + serverPort, null);
      }
    }

    @GetMapping("payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("getPayment id:{}", id);
        Payment payment = paymentService.getPayment(id);
        if (payment == null) {
            return new CommonResult(444, "not find, serverPort:" + serverPort, null);
        } else {
            return new CommonResult(200, "success, serverPort:" + serverPort, payment);
        }
    }

    @GetMapping("/payment/lb")
    public String paymentLb() {
        return serverPort;
    }
}
