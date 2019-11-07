package com.jarvis.rocket_stream;

import com.jarvis.rocket_stream.driver.CustomBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableBinding({Source.class, Sink.class, CustomBinding.class})
public class RocketStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketStreamApplication.class, args);
    }

}
