package com.jarvis.rocket_stream.service;

import com.jarvis.rocket_stream.driver.CustomBinding;
import com.jarvis.rocket_stream.model.User;
import org.apache.rocketmq.common.message.MessageConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomProducer {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    @Qualifier(CustomBinding.OUTPUT1)
    MessageChannel channel;

    public void sendMessage(User user){
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_TAGS, "userTags");
        MessageHeaders messageHeaders = new MessageHeaders(headers);
        Message<User> message = MessageBuilder.createMessage(user, messageHeaders);
        logger.info("sendMessage:{}", message);
        this.channel.send(message);
    }
}
