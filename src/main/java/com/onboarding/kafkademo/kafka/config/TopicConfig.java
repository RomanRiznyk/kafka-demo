package com.onboarding.kafkademo.kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;


@Configuration
public class TopicConfig {

    @Value("${spring.kafka.topics.topic1}")
    private String topic1;

    @Value("${spring.kafka.topics.topic2}")
    private String topic2;

    @Value("${spring.kafka.topics.topic3}")
    private String topic3;

    @Bean
    public KafkaAdmin.NewTopics topics123() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name(topic1)
                        .partitions(1)
                        .replicas(1)
                        .build(),
                TopicBuilder.name(topic2)
                        .partitions(1)
                        .replicas(1)
                        .build(),
                TopicBuilder.name(topic3)
                        .partitions(10)
                        .replicas(3)
                        .build());
    }
}

