package com.atguigu.springcloud.service;

import java.math.BigDecimal;

public interface AccountService {
    int decrease(Long userId, BigDecimal money);
}
