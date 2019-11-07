package com.jarvis.rocket_stream.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
public class SinkConsumer {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @StreamListener(Sink.INPUT)
    public void inputConsumer(String message){
        logger.info("message:{}", message);
    }
}
