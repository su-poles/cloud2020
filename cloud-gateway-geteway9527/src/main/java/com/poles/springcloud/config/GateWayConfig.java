package com.poles.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/14 3:47 下午
* 配置网关有两种方式，一种是在yml文件中直接配置，另一种是通过编码配置，这里就是编码配置。 两种方式都可以在官网去查看。getway官网去看。
 *
*********************************************************************
*/
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        //对应yml文件中的routes标签
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        //如果匹配/guonei, 在访问http://news/baidu.com/guonei， 类似一个map
        //即，访问localhost:9527/guonei, 则本质上会访问：http://news/baidu.com/guonei
        routes.route("route_path_0", r -> r.path("/").uri("http://news.baidu.com")).build();
        routes.route("route_path_1", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        //国际新闻
        routes.route("route_path_2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }

    //军事新闻：mil
    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        //即，访问localhost:9527/mil, 则本质上会访问：http://news/baidu.com/mil
        routes.route("route_path_3", r -> r.path("/mil").uri("http://news.baidu.com/mil")).build();
        return routes.build();
    }
}
