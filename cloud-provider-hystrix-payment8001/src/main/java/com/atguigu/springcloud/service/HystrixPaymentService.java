package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixPaymentService {

    public String paymentInfoOK(Integer id) {
        return "线程池： " + Thread.currentThread().getName()
                + "   paymentInfo_OK,id:" + id + " 正常访问！";
    }

    @HystrixCommand(fallbackMethod = "paymentFallback", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String paymentInfoTimeout(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName()
                + "   paymentInfo_OK,id:" + id + " 耗时(秒):" + timeNumber;
    }

    private String paymentFallback(Integer id) {
        return "这是8001 payment 服务的降级方法, id:" + id + ", 当前线程池名称：" + Thread.currentThread().getName();
    }
}
