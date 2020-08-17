package com.poles.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/6 10:33 上午
*
*********************************************************************
*/
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public String paymentZk(){
        return "spring cloud with zookeeper2: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
