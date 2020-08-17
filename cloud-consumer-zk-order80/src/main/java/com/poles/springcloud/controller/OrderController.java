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
* @date 2020/8/6 12:59 下午
*
*********************************************************************
*/
@RestController
@Slf4j
public class OrderController {

    @Value("${server.port}")
    private int serverPort;

    @Resource
    private RestTemplate restTemplate;

    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @GetMapping("/consumer/payment/zkinfo")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }

}
