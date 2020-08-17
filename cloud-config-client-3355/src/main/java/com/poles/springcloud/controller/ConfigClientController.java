package com.poles.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ********************************************************************
 *
 * @author poles
 * @date 2020/8/17 11:38 上午
 * <p>
 * ********************************************************************
 */
@RestController
@Slf4j
@RefreshScope           //刷新配置，当config.info有变化时，可以手动刷新，参考yml文件注释
public class ConfigClientController {

    /**
     * 1.首先bootstrap.yml是系统级别的，application.yml是用户级别的，系统级别的 优先级 > 用户级别的优先级
     * 2.config.info配置文件在某个git项目中：git@github.com:su-poles/springcloud-config.git
     * 而此项目启动时，肯定需要加载到内容，否则会报错，需要添加jar包：
     *      <dependency>
     *             <groupId>org.springframework.cloud</groupId>
     *             <artifactId>spring-cloud-starter-config</artifactId>
     *      </dependency>
     *
     * 3.通过直接访问注册中心可以查看配置文件内容：http://localhost:3344/master/config-dev.yml
     * 4.由于这里的configInfo已经加载完成，我们可以通过一个rest接口l暴露这个配置内容
     *     访问：http://localhost:3355/configInfo  查看
     */
    @Value("${config.info}")
    private String configInfo;

    /**
     * 通过该接口暴露配置文件内容，用来查看和验证配置文件内容
     * @date 2020-08-17 11:52:31
     */
    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
