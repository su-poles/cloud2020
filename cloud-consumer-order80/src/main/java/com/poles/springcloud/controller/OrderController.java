package com.poles.springcloud.controller;

import com.poles.springcloud.entities.CommonResult;
import com.poles.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * ********************************************************************
 * 客户端调用服务：cloud-provider-payment8001, 这里暂时需要restTemplate调用
 *
 * @author poles
 * @date 2020/8/3 12:21 下午
 * <p>
 * ********************************************************************
 */
@RestController
@Slf4j
public class OrderController {

    //直接指定服务器地址，直接访问8001服务
    //public final String PAYMENT_URL = "http://localhost:8001";

    //先通过查询注册服务获取实际提供服务的地址，然后再去访问，这个真实地址由负载均衡器进行分配
    public final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("创建支付服务, 请求参数：" + payment);
        //通过Eureka的服务发现功能，根据CLOUD-PAYMENT-SERVICE查找到服务器的真实访问地址
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        log.info("查询支付服务, 请求Id：" + id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public String getPaymentForEntity(@PathVariable("id") Long id) {
        log.info("******************************************1");
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        log.info("******************************************2");
        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info("******************************************3");
            log.info(entity.getStatusCode() + "\t" + entity.toString());
            //            return entity.getBody();
            return entity.toString();
        } else {
            log.info("******************************************4");
            return "查询失败， entity=" + entity;
        }
    }

    //增加一个接口，调用8001的zipkin接口，用来观察sleuth得到的调用链路，在http://localhost:9411上查看
    @GetMapping("consumer/payment/zipkin")
    public String paymentZipKin() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
    }
}
