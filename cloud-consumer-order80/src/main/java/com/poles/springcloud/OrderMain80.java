package com.poles.springcloud;

import com.poles.balancerule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/3 12:19 下午
*
 * 启动前，需要先启动Eureka集群，即7001~7003服务
 * 对应的服务提供者为8001~8002服务，也是一个集群
*********************************************************************
*/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRibbonRule.class)  //@RibbonClient如果不写，默认就是采用轮询的负载均衡策略，这里指定对服务提供者CLOUD-PAYMENT-SERVICE采用的负载均衡策略为自定义的RibbonRule策略
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
