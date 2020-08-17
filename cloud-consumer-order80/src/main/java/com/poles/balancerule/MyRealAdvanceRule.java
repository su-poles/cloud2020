package com.poles.balancerule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/7 6:01 下午
*
*********************************************************************
*/
public class MyRealAdvanceRule extends RandomRule {
    //这里实现自定义的真真的高级负载策略：本地负载均衡（应用内的LB），区别于服务端的负载均衡（集中式的LB，类似于LVS、Nginx等，硬件的F5等）
}
