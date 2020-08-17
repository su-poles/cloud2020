package com.poles.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/15 10:12 上午
* 实现自定义过滤器
*********************************************************************
*/
@Component
@Slf4j
public class myFilter implements GlobalFilter, Ordered {

    /**
     * 该方法有两个参数，第一个就是封装的路由对象，里面包含请求的所有内容
     * 第二个参数为调用链，如果过滤器通过，则传给过滤链，下一个过滤器接着请求处，
     * 访问：http://localhost:9527/payment/lb                      //HTTP ERROR 406, 该网页无法正常运作, 如果问题仍然存在，请与网站所有者联系
     * 访问：http://localhost:9527/payment/lb?name=abc             //正常访问
     * 访问：http://localhost:9527/payment/get/3                   //406
     * 访问：http://localhost:9527/payment/get/3?name=abc          //正常访问
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("******* 进入了自定义的全局过滤器 ~~~~~ myFilter ~~~~~");
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if(name == null){
            log.info("请求参数非法，name 不能为空！");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //过滤器的优先级，数字越小，优先级越高
        return 0;
    }
}
