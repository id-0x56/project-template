package com.example.common.message;

import com.example.common.event.TypeEvent;

import java.io.Serializable;

public interface Message<T> extends Serializable {
    T getPayload();

    TypeEvent getTypeEvent();
}
