package com.poles.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/7 11:37 上午
* 启动前，需要启动consul服务，并在application.yml中配置consul服务的consul地址
 * consul的配置与启动，可以在网易云笔记中查找安装和启动笔记。
*********************************************************************
*/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulOrderMain80.class, args);
    }
}
