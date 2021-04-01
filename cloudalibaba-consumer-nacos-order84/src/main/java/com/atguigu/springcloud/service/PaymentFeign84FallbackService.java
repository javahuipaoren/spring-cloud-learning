package com.atguigu.springcloud.service;

import com.atguigu.cloud.api.entity.CommonResult;
import com.atguigu.cloud.api.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeign84FallbackService implements PaymentFeign84Service {

    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(444,"服务降级返回，---PaymentFeign84FallbackService",new Payment(id,"ErrorSerial"));
    }
}
