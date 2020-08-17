package com.poles.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/6 6:35 下午
*
*********************************************************************
*/
@RestController
public class Payment {

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/payment/consul")
    public String paymentConsul(){
        return "springcloud with consol:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
