package com.poles.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.poles.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/10 5:42 下午
*
*********************************************************************
*/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private int serverPort;


    //=======================================服务降级示例===========================
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoOk(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoTimeOut(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping("/payment/hystrix/expection/{id}")
    public String paymentInfoExpetion(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoExpcetion(id);
        log.info("*****result: " + result);
        return result;
    }

    //=======================================服务熔断示例===========================
    @GetMapping("payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("******result:" + result);
        return result;
    }

}
