package com.onboarding.kafkademo.kafka.consumer;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerGroup3 {
    @Value("${spring.kafka.groups.group3}")
    private String group3;

    @Value("${spring.kafka.topics.topic3}")
    private String topic3;

    @KafkaListener(topics = "${spring.kafka.consumer.topic.topic3}, ", groupId = "${spring.kafka.groups.group3}")
    public void consume4(String msg) {
        log.info("=> group {} consumed from topic {} : {}", group3, topic3, msg);
    }
}