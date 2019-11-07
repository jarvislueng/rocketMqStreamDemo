package com.jarvis.rocket_stream.service;

import com.jarvis.rocket_stream.driver.CustomBinding;
import com.jarvis.rocket_stream.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class CustomConsumer {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @StreamListener(CustomBinding.INPUT1)
    public void input(User user){
        logger.info("receiveMessage:{}", user);
    }
}
