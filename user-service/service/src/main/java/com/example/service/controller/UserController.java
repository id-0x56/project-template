package com.example.service.controller;

import com.example.api.dto.UserDto;
import com.example.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> index() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.all());
    }

    @PostMapping
    public ResponseEntity<?> store(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.create(userDto));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> show(@PathVariable String uuid) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.find(uuid));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> update(@PathVariable String uuid, @RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(userService.update(uuid, userDto));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> destroy(@PathVariable String uuid) {
        userService.delete(uuid);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }
}
