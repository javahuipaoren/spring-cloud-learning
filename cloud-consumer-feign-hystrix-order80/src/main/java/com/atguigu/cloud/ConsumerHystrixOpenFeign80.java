package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class ConsumerHystrixOpenFeign80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixOpenFeign80.class, args);
    }
}
