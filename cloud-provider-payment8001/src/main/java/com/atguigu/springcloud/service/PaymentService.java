package com.atguigu.springcloud.service;

import com.atguigu.cloud.api.entity.Payment;

public interface PaymentService {

    int save(Payment payment);

    Payment getPayment(Long id);
}
