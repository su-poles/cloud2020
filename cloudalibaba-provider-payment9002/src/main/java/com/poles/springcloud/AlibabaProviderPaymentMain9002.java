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
 * 2. 然后在VM options中添加： -DServer.port=9003  即可
 *
 * 方法二：
 * 1. 点击Edit Configurations...
 * 2. 新增Spring Boot启动项，然后名称输入为：AlibabaProviderPaymentMain9004
 * 3. Main Class 选择为9001的主启动类， VM options中添加： -DServer.port=9004  即可
 *
 *
 *  启动9001，9002，9003，9004四个项目
 *  然后在nacos服务中(http://localhost:8848/nacos) 的"服务管理--服务列表"中就会看到服务名为nacos-payment-provider的实例又4个（9001-9004）
*********************************************************************
*/
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProviderPaymentMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderPaymentMain9002.class, args);
    }
}
