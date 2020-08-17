package com.poles.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/17 10:45 上午
* 配置中心，配置读取规则，总共5中，参考官网，下面推荐三种：
 * 1. /{label}/{application}-{profile}.yml    例如：http://localhost:3344/master/config-prod.yml
 * 2. /{application}-{profile}.yml            例如：http://localhost:3344/config-test.yml
 * 3. /{application}/{profile}[/{label}]      例如：http://localhost:3344/config/dev 或者  http://localhost:3344/config/test/dev/master
 *
 * 总结一下，可以通过多种方式访问配置文件，但是返回的格式略有不同，需要根据不同的情况自己解析配置信息
 * 一下方式都能访问到config-dev配置文件内容：
 * 1. http://localhost:3344/master/config-dev.yml
 * 2. http://localhost:3344/config-dev.yml
 * 3. http://localhost:3344/config/dev              //注意，没有yml后缀
 * 4. http://localhost:3344/config/dev/master       //注意，没有yml后缀
 * 5. http://localhost:3344/spring-config/dev.yml       //这种方式下，label和propertySources属性都为空, spring-config为工程名，默认取applicaition中配置的label指定的分支
 * 6. http://localhost:3344/spring-config/dev/master    // label有了，但是propertySources依然为空
 * 7. 查官方文档
 * 8. 推荐第一种：http://localhost:3344/master/config-dev.yml， 格式：/{label}/{application}-{profile}.yml
 *
*********************************************************************
*/
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
