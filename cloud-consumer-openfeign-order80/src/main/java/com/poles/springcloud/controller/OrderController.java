package com.poles.springcloud.controller;

import com.poles.springcloud.entities.CommonResult;
import com.poles.springcloud.entities.Payment;
import com.poles.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/8 12:44 下午
*
*********************************************************************
*/

@RestController
public class OrderController {

    @Resource
    PaymentService paymentService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentInfo(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String feignTimeoutTest(){
        // openfeign-ribbon客户端一般等待超时时间为1秒钟，而此时服务端响应设定的是3秒钟
        return paymentService.feignTimeoutTest();
    }
}
