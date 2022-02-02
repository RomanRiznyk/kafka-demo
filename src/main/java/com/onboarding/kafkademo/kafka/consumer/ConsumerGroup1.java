package com.onboarding.kafkademo.kafka.consumer;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerGroup1 {
    @Value("${spring.kafka.groups.group1}")
    private String group1;

    @Value("${spring.kafka.groups.group2}")
    private String group2;

    @Value("${spring.kafka.topics.topic1}")
    private String topic1;

    @Value("${spring.kafka.topics.topic2}")
    private String topic2;

    @Value("${spring.kafka.topics.topic3}")
    private String topic3;

    @KafkaListener(topics = "${spring.kafka.consumer.topic.topic1}", groupId = "${spring.kafka.groups.group1}")
    public void consume1(String msg) {
        log.info("=> group {} consumed: {}", group1, msg);
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic.topic1}", groupId = "${spring.kafka.groups.group2}")
    public void consume2(String msg) {
        log.info("=> group {} consumed from topic {} : {}", group2, topic1, msg);
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic.topic2}", groupId = "${spring.kafka.groups.group2}")
    public void consume3(String msg) {
        log.info("=> group {} consumed from topic {} : {} ", group2, topic2, msg);
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic.topic3}, ", groupId = "${spring.kafka.groups.group2}")
    public void consume4(String msg) {
        log.info("=> group {} consumed from topic {} : {}", group2, topic3, msg);
    }
}