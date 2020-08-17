package com.poles.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/7 11:38 上午
*
*********************************************************************
*/
@RestController
@Slf4j
public class OrderController {

    private final static String INVOKE_URL = "http://cloud-consul-provider-payment";

    @Value("${server.port}")
    private int serverPort;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String getPaymentConsul(){
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }
}
