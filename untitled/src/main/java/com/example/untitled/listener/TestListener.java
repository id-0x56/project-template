package com.example.untitled.listener;

import com.example.api.dto.UserDto;
import com.example.common.message.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener {
    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Message<UserDto> message) {
        System.out.println(message);
    }
}
