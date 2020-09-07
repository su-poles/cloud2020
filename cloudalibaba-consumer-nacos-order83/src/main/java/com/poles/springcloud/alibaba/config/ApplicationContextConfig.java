package com.poles.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/19 11:21 上午
* 只要使用到RestTemplate，就需要注入，就需要提供这么一个类
*********************************************************************
*/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
