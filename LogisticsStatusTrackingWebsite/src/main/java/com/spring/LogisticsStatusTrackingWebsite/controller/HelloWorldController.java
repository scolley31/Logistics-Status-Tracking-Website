package com.spring.LogisticsStatusTrackingWebsite.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final StringRedisTemplate stringRedisTemplate;

    public HelloWorldController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @GetMapping("/api/hello")
    public ResponseEntity<String> HelloWorld() {
        stringRedisTemplate.opsForValue().set("scolley", "123456");
        return ResponseEntity.ok("Hello World");
    }
}
