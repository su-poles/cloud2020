package com.poles.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/19 11:10 上午
*
*********************************************************************
*/
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaCloudConsumerNacosMain83 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaCloudConsumerNacosMain83.class, args);
    }
}
