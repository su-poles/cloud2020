package com.poles.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/17 11:37 上午
*
 * 结合消息总线bus+rabbitmq,
 * 当配置文件更新之后（配置文件在git项目中，例如：git@github.com:su-poles/springcloud-config.git）
 * 只需要给服务中心，即cloud-config-center-3344发送bus-refresh消息，其它客户端均会直接更新为最新的配置文件
 *
 *
 * 1. 3344为服务中心，与git配置文件直连，所以每次肯定都是最新的，比如更新配置文件后访问：http://localhost:3344/master/config-dev.yml， 总是最新的
 * 2. 3355和3366作为配置服务的客户端，即要拉取最新的配置文件，如果单独拉取，则执行：curl -X POST "http://localhost:3366/actuator/refresh" 即可（端口号分别为3355和3366）
 * 3. 也可以通过执行curl -X  POST http://localhost:3344/actuator/bus-refresh，则所有的客户端均会刷新为最新的配置文件
 *    因为，每个config-client都在监听MQ（bus支持rabbitmq和kafka）, 当给3344发送bus-refresh时，会给mq发送更新的消息，其它监听mq的客户端都会刷新配置
 *
 * 4. 如果未生效：
 *    4.1 检查jar包是否引入消息总线-amqp
 *            <dependency>
 *              <groupId>org.springframework.cloud</groupId>
 *              <artifactId>spring-cloud-starter-bus-amqp</artifactId>
 *            </dependency>
 *    4.2 controller中是否添加@RefreshScop注解
 *    4.3 MQ配置是否正确，rabbitmq一定是在spring下，是否对齐，host与用户名密码是否正确，密码有特殊符号也不需要加引号
 *    4.4 yml是否配置暴露端点endPoint
 *
 *
 *  5. 以上为全局发送，即配置中心修改配置文件后，发送bus-refresh命令，则所有需要配置的客户端均会更新配置文件，那么可以在
 *     bus-refresh后面指定需要更新的客户端，格式为：
 *     格式： curl -X  POST http://localhost:3344/actuator/bus-refresh/{spring.application.name}:{server.port}
 *     例如只修改3355：curl -X  POST http://localhost:3344/actuator/bus-refresh/config-client:3355
 *
 *     通过命令查看，果然只改了3355，3366没更新：
 *     3355查看：http://localhost:3355/configInfo
 *     3366查看：http://localhost:3366/configInfo
*********************************************************************
*/
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class, args);
    }
}