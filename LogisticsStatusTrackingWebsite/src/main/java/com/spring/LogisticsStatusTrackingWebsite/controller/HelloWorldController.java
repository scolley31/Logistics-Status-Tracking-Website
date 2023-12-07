package com.spring.LogisticsStatusTrackingWebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @GetMapping("/api/hello")
    public ResponseEntity<String> HelloWorld() {
        stringRedisTemplate.opsForValue().set("scolley", "111");
        return ResponseEntity.ok("Hello World");
    }
}
