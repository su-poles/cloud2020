package com.poles.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/6 12:57 下午
*
 * 启动前，需要先启动zookeeper服务，安装和启动可以参考网易云笔记。
*********************************************************************
*/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZKMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZKMain80.class, args);
    }
}
