package com.onboarding.kafkademo.kafka.consumer;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerGroup2 {
    @Value("${spring.kafka.groups.group2}")
    private String group2;

    @Value("${spring.kafka.topics.topic1}")
    private String topic1;

    @Value("${spring.kafka.topics.topic2}")
    private String topic2;

    @KafkaListener(topics = "${spring.kafka.consumer.topic.topic1}", groupId = "${spring.kafka.groups.group2}")
    public void consume2(String msg) {
        log.info("=> group {} consumed from topic {} : {}", group2, topic1, msg);
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic.topic2}", groupId = "${spring.kafka.groups.group2}")
    public void consume3(String msg) {
        log.info("=> group {} consumed from topic {} : {} ", group2, topic2, msg);
    }
}