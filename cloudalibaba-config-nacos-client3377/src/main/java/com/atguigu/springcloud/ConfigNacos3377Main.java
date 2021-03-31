package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigNacos3377Main {

    public static void main(String[] args) {
        SpringApplication.run(ConfigNacos3377Main.class, args);
    }
}
