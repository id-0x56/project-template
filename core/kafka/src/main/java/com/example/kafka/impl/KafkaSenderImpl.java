package com.example.kafka.impl;

import com.example.kafka.KafkaSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KafkaSenderImpl implements KafkaSender {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopicName;

    @Override
    public <T> void sendDefault(T value) {
        send(defaultTopicName, value);
    }

    @Override
    public <T> void sendDefault(String key, T value) {
        send(defaultTopicName, key, value);
    }

    @Override
    public <T> void send(String topicName, T value) {
        String key = UUID.randomUUID().toString();
        send(topicName, key, value);
    }

    @Override
    public <T> void send(String topicName, String key, T value) {
        kafkaTemplate.send(topicName, key, value);
    }
}
