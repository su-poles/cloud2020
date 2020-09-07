package com.poles.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/19 3:35 下午
*
*********************************************************************
*/
@RestController
@RefreshScope   //只是nacos的动态刷新功能
public class NacosClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}
