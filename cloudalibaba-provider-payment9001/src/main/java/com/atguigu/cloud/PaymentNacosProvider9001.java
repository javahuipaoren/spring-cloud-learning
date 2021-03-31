package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentNacosProvider9001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentNacosProvider9001.class, args);
    }
}
