package com.poles.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/18 11:42 上午
*
*********************************************************************
*/
@Component
@EnableBinding(Sink.class)
public class consumer {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void getMessage(Message<String> message){
        System.out.println("收到消费消息：" + message.getPayload() + ", 端口号：" + serverPort);
    }
}
