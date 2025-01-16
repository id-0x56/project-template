package com.example.service.event.impl;

import com.example.api.dto.UserDto;
import com.example.common.event.TypeEvent;
import com.example.common.message.BaseMessage;
import com.example.kafka.KafkaSender;
import com.example.service.event.UserEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEventImpl implements UserEvent {
    private final KafkaSender kafkaSender;

    @Value("${spring.kafka.template.default-topic}")
    private String topicName;

    @Override
    public void created(UserDto userDto) {
        send(userDto, TypeEvent.USER_CREATED);
    }

    @Override
    public void updated(UserDto userDto) {
        send(userDto, TypeEvent.USER_UPDATED);
    }

    @Override
    public void deleted(UserDto userDto) {
        send(userDto, TypeEvent.USER_DELETED);
    }

    private <T> void send(T payload, TypeEvent typeEvent) {
        kafkaSender.send(topicName, BaseMessage.builder()
                .payload(payload)
                .typeEvent(typeEvent)
                .build()
        );
    }
}
