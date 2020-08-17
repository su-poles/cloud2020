package com.poles.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.poles.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;


/**
*********************************************************************
* 
* @author poles
* @date 2020/8/17 8:00 下午
*
*********************************************************************
*/

@EnableBinding(Source.class)       //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;      //消息发送管道

    @Override
    public String send() {

        //生成一个随机流水号
        String uuid = IdUtil.simpleUUID();

        //构建一个消息对象
        Message<String> message = MessageBuilder.withPayload(uuid).build();

        //发送消息到通道
        output.send(message);

        System.out.println("******发送消息：" + uuid);
        return uuid;
    }
}
