package com.jarvis.rocket_stream;

import com.jarvis.rocket_stream.model.User;
import com.jarvis.rocket_stream.service.CustomProducer;
import com.jarvis.rocket_stream.service.SourceProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketStreamApplicationTests {

    @Autowired
    SourceProducer producer;

    @Autowired
    CustomProducer customProducer;
    @Test
    public void contextLoads() {
        this.producer.sendMessage("jarvis");
    }

    @Test
    public void customSend(){
        this.customProducer.sendMessage(new User("123", "jarvis"));
    }

}
