package com.poles.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/18 6:47 下午
*
*********************************************************************
*/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/echo/{str}")
    public String echo(@PathVariable String str){
        return "echo：" + str + ", serverPort: " + serverPort;
    }
}
