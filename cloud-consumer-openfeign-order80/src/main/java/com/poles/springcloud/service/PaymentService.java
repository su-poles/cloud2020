package com.poles.springcloud.service;

import com.poles.springcloud.entities.CommonResult;
import com.poles.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/8 12:46 下午
*
*********************************************************************
*/

@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    /**
     * 这里调用的是8001~8002服务的controller里暴露的接口，即URL
     */
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * 调用@FeignClient指定的微服务中，暴露的payment/feign/timeout接口（指的是8001~8002服务器中controller中定义的URL）
     * 需要在yml中配置超时时间
     */
    @GetMapping("payment/feign/timeout")
    public String feignTimeoutTest();
}
