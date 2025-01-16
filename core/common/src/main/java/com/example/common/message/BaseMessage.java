package com.example.common.message;

import com.example.common.event.TypeEvent;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseMessage<T> implements Message<T> {
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    private T payload;

    private TypeEvent typeEvent;
}
