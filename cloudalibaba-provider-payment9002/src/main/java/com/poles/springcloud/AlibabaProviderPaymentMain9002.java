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
 * 本项目是完全克隆的9001， 其实可以直接启动两个9001项目，然后将第二个项目制定一个9002即可
 *
 * 我们现在启动一个9001服务，然后指定端口为9003，由此可以模拟集群环境，以下为步骤：
 *
 * 方法一：
 * 1. 在Services窗口中，右键点击启动项目选择Copy Configurations...
 * 2. 然后
*********************************************************************
*/
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProviderPaymentMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderPaymentMain9002.class, args);
    }
}
