package com.atguigu.springcloud.dao;

import com.atguigu.cloud.api.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao8002 {

    int insert(Payment payment);

    Payment getPaymentByPrimaryKey(Long id);
}
