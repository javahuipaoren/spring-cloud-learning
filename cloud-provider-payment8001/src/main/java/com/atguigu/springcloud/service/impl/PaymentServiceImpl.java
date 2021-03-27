package com.atguigu.springcloud.service.impl;

import com.atguigu.cloud.api.entity.Payment;
import com.atguigu.springcloud.dao.PaymentDao8001;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao8001 paymentDao;

    public int save(Payment payment) {
        return paymentDao.insert(payment);
    }

    public Payment getPayment(Long id) {
        return paymentDao.getPaymentByPrimaryKey(id);
    }
}
