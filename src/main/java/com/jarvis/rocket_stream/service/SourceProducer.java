package com.jarvis.rocket_stream.service;

import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SourceProducer {
    @Autowired
//    @Qualifier(Source.OUTPUT)
    private Source source;

    /**
     * 也可以指定注入成MessageChannel，但是需要指定对应的beanName
     * */
    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel messageChannel;


    public void sendMessage(String msg){
        String payload = msg;
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_TAGS, "testTag");
        MessageHeaders messageHeaders = new MessageHeaders(headers);
        Message<String> message = MessageBuilder.createMessage(payload, messageHeaders);
//        this.source.output().send(message);
        messageChannel.send(message);
    }
}
