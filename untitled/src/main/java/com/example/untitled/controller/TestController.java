package com.example.untitled.controller;

import com.example.untitled.service.TestService;
import net.datafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    private final TestService service;
    public Faker faker;

    public TestController(TestService service) {
        this.service = service;
        this.faker = new Faker();
    }

    @GetMapping("/hello")
    public String hello() {
        return service.get(faker.name().firstName(), faker.name().lastName());
    }
}
