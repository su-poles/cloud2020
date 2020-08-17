package com.poles.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/10 9:35 下午
*
*********************************************************************
*/
@SpringBootApplication
@EnableFeignClients
@EnableHystrix  //启用降级服务，配合yml
public class FeignHystrixOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixOrderMain80.class, args);
    }
}
