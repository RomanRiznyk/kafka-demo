package com.onboarding.kafkademo.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class Producer {
    @Value(value = "${spring.kafka.template.default-topic}")
    private String topicName;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produce(String msg) {
        kafkaTemplate.send(topicName, msg);
    }
}
