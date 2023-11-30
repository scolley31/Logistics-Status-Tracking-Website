package com.spring.LogisticsStatusTrackingWebsite.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/api/hello")
    public ResponseEntity<String> HelloWorld() {
        return ResponseEntity.ok("Hello World");
    }
}
