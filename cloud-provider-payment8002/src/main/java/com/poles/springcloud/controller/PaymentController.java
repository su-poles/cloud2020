package com.poles.springcloud.controller;

import com.poles.springcloud.entities.CommonResult;
import com.poles.springcloud.entities.Payment;
import com.poles.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/3 9:26 上午
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

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.insert(payment);
        log.info("*****插入结果：" + result);
        if(result > 0){
            return new CommonResult<Integer>(200, "创建数据成功，响应服务器为：" + serverPort, result);
        }else{
            return new CommonResult<Integer>(10020, "创建数据失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult<Payment>(200, "查询成功，响应服务器为：" + serverPort, payment);
        }else{
            return new CommonResult<Payment>(10021, "记录不存在", null);
        }
    }


    @GetMapping(value = "/payment/discovery")
    public DiscoveryClient discoveryClient(){
        //打印服务名称列表
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> log.info("*****element: " +  service));

        //打印服务名称CLOUD-PAYMENT-SERVICE对应的服务提供者的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance->log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri()));

        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public int getPaymentLb(){
        return serverPort;
    }

    @GetMapping("payment/feign/timeout")
    public String feignTimeoutTest(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "业务处理时间为3秒，port=" + serverPort;
    }

}
