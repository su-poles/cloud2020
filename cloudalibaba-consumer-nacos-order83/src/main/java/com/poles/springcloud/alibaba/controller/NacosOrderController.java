package com.poles.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/19 11:23 上午
*
*********************************************************************
*/
@RestController
@Slf4j
public class NacosOrderController {
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("/consumer/echo/{str}")
    public String getPayment(@PathVariable("str") String str){
        return restTemplate.getForObject(serverUrl + "/echo/" + str, String.class);
    }
}
