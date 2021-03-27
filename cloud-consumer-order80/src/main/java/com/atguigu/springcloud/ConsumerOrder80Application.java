package com.atguigu.springcloud;

import com.atguigu.rule.RuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = RuleConfig.class)
public class ConsumerOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder80Application.class, args);
    }
}
