package com.poles.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/18 6:16 下午
*
*********************************************************************
*/
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProviderPaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderPaymentMain9001.class, args);
    }
}
