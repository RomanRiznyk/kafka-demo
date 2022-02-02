package com.onboarding.kafkademo.service;

import com.onboarding.kafkademo.kafka.producer.Producer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class HelloToViaKafkaService implements HelloToService {
    private final Producer producer;

    @Override
    public String sayHello(String name) {  // todo Optional
        String msg;
        if (name == null) {
            msg = "Hello, World! Plz, write your name in request.";
            producer.produce(msg);
            return msg;
        }
        msg = "Hello, " + name + "!";
        producer.produce(msg);
        log.info("=> sent: {}", msg);
        return msg;
    }
}
