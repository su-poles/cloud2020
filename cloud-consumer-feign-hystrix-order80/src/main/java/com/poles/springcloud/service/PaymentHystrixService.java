package com.poles.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
//@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE")
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE", fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentTiemout(@PathVariable("id") Integer id);
}
