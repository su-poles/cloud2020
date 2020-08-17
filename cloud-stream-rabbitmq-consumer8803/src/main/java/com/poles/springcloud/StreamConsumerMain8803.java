package com.poles.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/17 5:45 下午
*
*********************************************************************
*/
@SpringBootApplication
@EnableEurekaClient
public class StreamConsumerMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerMain8803.class, args);
    }
}
