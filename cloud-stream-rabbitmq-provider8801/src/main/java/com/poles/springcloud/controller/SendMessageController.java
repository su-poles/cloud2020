package com.poles.springcloud.controller;

import com.poles.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/17 8:11 下午
*
*********************************************************************
*/
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send/message")
    public String sendMessage(){
        return messageProvider.send();
    }
}
