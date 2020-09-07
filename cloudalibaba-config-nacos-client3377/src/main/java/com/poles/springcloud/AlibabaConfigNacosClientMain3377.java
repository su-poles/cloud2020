package com.poles.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/19 3:06 下午
* 当Nacos作为配置中心时：
 * 1. 导入jar包：
 *          <!-- 引入springcloud nacos 配置中心功能-->
 *         <dependency>
 *             <groupId>com.alibaba.cloud</groupId>
 *             <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 *         </dependency>
 *
 * 2. 哪里加载配置文件，哪里就需要增加@RefreshScope注解以支持Nacos中配置文件自动刷新的功能
 * 3. 对于配置文件的多环境问题，Nacos提供三级隔离措施：
 *      3.1 DataId方案：使用默认的namespace + 默认的分组，仅通过更新：spring.profiles.active: dev 来获取对应的配置文件
 *      3.2 Group方案：使用默认的namespace + 固定的环境变量，比如：spring.profiles.active：info， 然后通过更新group参数来获取不同的配置文件
 *      3.3 Namespace方案：使用不同的namespace来获取不同路径下的配置文件。
 *      这个跟基本的权限分配一个道理，用户+角色+功能可以自由分配，通过 Namespace + Group + DataId 可以配合设置复杂的环境变量
*********************************************************************
*/
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaConfigNacosClientMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaConfigNacosClientMain3377.class, args);
    }
}
