package com.jarvis.rocket_stream.driver;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface CustomBinding {
    public static final String INPUT1 = "jarvisCustemInput";
    public static final String OUTPUT1 = "jarvisCustemOutput";

    @Input(CustomBinding.INPUT1)
    SubscribableChannel input();

    @Output(CustomBinding.OUTPUT1)
    MessageChannel output();
}
