package com.atguigu.springcloud.controller;

import com.atguigu.cloud.api.entity.CommonResult;
import com.atguigu.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("usrId") Long userId, @RequestParam("money") BigDecimal money) {
        log.info("account controller, userId:{}, money:{}", userId, money);
        accountService.decrease(userId, money);
        return new CommonResult(200, "账户扣减成功");
    }
}
