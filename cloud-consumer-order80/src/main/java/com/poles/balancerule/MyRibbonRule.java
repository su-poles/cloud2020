package com.poles.balancerule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/7 5:17 下午
*
 * 注意点：
 * 1.注解 @SpringbootApplication包含了注解@ComponetScan
 * 2. Ribbon的配置必须用@Configuration注解标识，并且不能被@Component注解或者@SpringBootApplication（因为里面包含了@Component）扫描到。因为如果被@ComponentScan扫描到会导致所有的RibbonClient都去共享这个配置。
 * 3. 这里配置了负载策略之后，需要在主启动类中通过@RibbonClient注解指定该负载策略
*********************************************************************
*/
@Configuration
public class MyRibbonRule {  //这里提示Application context not configured for this file, 表示不能被扫描到Spring容器中，实际上不在@ComponentScan的范围内。没关系，启动类启动时会通过@RibbonClient指定这个类的，指定了当然会加载了。

    @Bean
    public IRule setRule(){
        //1. 轮询策略：
        //return new RoundRobinRule();

        //2. 随机策略：负载均衡策略指定为随机
        //return new RandomRule();

        //3. 重试策略：先按照轮询策略获取服务，如果获取服务失败则在指定时间内进行重试
        //return new RetryRule();

        //4. 响应速度优先：对于轮询的扩展，响应速度越快的实例选择权重越大，越容易被选择
        //return new WeightedResponseTimeRule();

        //5.会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
        //return new BestAvailableRule();

        //6.先过滤掉故障实例，再选择并发较小的实例
        //return new AvailabilityFilteringRule();

        //7.默认规则，符合判断server所在区域的性能和可用性来选择哪个服务
        //return new ZoneAvoidanceRule();

        //8. 自定义策略，基础AbstractLoadBalancerRule或者实现IRule接口即可。
        return new MyRealAdvanceRule();
    }
}
