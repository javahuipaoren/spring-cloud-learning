package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsulConsumerController {

    private static final String REQUEST_URL = "http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/consumer/consul")
    public String consume() {
        return restTemplate.getForObject(REQUEST_URL + "/payment/consul", String.class);
    }
}
