package com.example.service.event;

import com.example.api.dto.UserDto;

public interface UserEvent {
    void created(UserDto userDto);
    void updated(UserDto userDto);
    void deleted(UserDto userDto);
}
