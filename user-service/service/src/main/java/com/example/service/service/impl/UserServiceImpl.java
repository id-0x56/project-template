package com.example.service.service.impl;

import com.example.api.dto.UserDto;
import com.example.service.entity.UserEntity;
import com.example.service.event.UserEvent;
import com.example.service.exception.NotFoundException;
import com.example.service.mapper.UserMapper;
import com.example.service.repository.UserRepository;
import com.example.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final UserEvent userEvent;

    @Override
    public List<UserDto> all() {
        List<UserDto> foundUserDtoList = userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());

        return foundUserDtoList;
    }

    @Override
    public UserDto create(UserDto userDto) {
        UserEntity createbleUserEntity = userMapper.toEntity(userDto);

        UserEntity createdUserEntity = userRepository.save(createbleUserEntity);

        UserDto createdUserDto = userMapper.toDto(createdUserEntity);
        userEvent.created(createdUserDto);

        return createdUserDto;
    }

    @Override
    public UserDto find(String uuid) {
        UserEntity foundUserEntity = userRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("User with uuid: '%s' not found".formatted(uuid)));

        UserDto foundUserDto = userMapper.toDto(foundUserEntity);

        return foundUserDto;
    }

    @Override
    public UserDto update(String uuid, UserDto userDto) {
        UserEntity updatableUserEntity = userRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("User with uuid: '%s' not found".formatted(uuid)));

        updatableUserEntity.setEmail(userDto.getEmail());
        updatableUserEntity.setPassword(userDto.getPassword());

        UserEntity updatedUserEntity = userRepository.save(updatableUserEntity);

        UserDto updatedUserDto = userMapper.toDto(updatedUserEntity);
        userEvent.updated(updatedUserDto);

        return updatedUserDto;
    }

    @Override
    public void delete(String uuid) {
        UserEntity deletebleUserEntity = userRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("User with uuid: '%s' not found".formatted(uuid)));

        userRepository.deleteById(deletebleUserEntity.getId());

        UserDto deletedUserDto = userMapper.toDto(deletebleUserEntity);
        userEvent.deleted(deletedUserDto);
    }
}
