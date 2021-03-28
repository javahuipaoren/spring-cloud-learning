package com.atguigu.cloud.fallback;

import com.atguigu.cloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfoOK(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_Timeout,o(╥﹏╥)o";
    }
}
