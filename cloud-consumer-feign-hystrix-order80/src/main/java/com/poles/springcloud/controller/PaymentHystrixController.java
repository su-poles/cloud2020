package com.poles.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.poles.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/10 9:40 下午
*
*********************************************************************
*/
@RestController
@DefaultProperties(defaultFallback = "paymentDefaultTimeoutControllerFallback")
public class PaymentHystrixController {
    @Resource
    PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    public int serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentOkController(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand    //可以制定降级类，如果不指定，就会走全局降级类，全局降级类通过在@DefaultProperties指定降级方法
//    @HystrixCommand(fallbackMethod = "paymentTimeoutControllerFallback", commandProperties = {
//            //调用服务时，如果1500毫秒内返回即为正常响应，否则直接走降级方法：paymentTimeoutControllerFallback
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="1500")
//    })
    public String paymentTimeoutController(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentTiemout(id);
    }

    public String paymentTimeoutControllerFallback(@PathVariable("id") Integer id){
        return "我是消费者80，对不起，系统繁忙，请稍后再试！";
    }

    /**
     * 该方法为全局降级方法，即全局兜底方法，没有参数，否则会报告未找到降级方法的异常
     */
    public String paymentDefaultTimeoutControllerFallback(){
        return "我是消费者80_defaultFallback，对不起，系统繁忙，请稍后再试！";
    }
}
