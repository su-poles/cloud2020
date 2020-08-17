package com.poles.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/6 10:31 上午
*
 * 启动前，需要先启动zookeeper服务，安装和启动可以参考网易云笔记。
*********************************************************************
*/
@SpringBootApplication
@EnableDiscoveryClient    //本注解用于向zk或者consul作为注册中心时的注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
