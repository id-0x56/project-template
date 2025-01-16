package com.example.service.service;

import com.example.api.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> all();
    UserDto create(UserDto userDto);
    UserDto find(String uuid);
    UserDto update(String uuid, UserDto userDto);
    void delete(String uuid);
}
