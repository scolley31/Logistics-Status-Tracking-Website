package com.spring.LogisticsStatusTrackingWebsite.controller;


import com.spring.LogisticsStatusTrackingWebsite.domain.response.ApiResponse;
import com.spring.LogisticsStatusTrackingWebsite.domain.response.ErrorResponse;
import com.spring.LogisticsStatusTrackingWebsite.domain.response.LogisticsStatus;
import com.spring.LogisticsStatusTrackingWebsite.service.LogisticsService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/logistics")
public class LogisticsController {

    private final LogisticsService logisticsService;
    private final StringRedisTemplate stringRedisTemplate;
    public LogisticsController(LogisticsService logisticsService, StringRedisTemplate stringRedisTemplate) {
        this.logisticsService = logisticsService;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @GetMapping("/query")
    public ResponseEntity<ApiResponse<LogisticsStatus>> queryLogisticsStatus(@RequestParam("sno") String logisticsNumber) {
        Optional<LogisticsStatus> logisticsStatus = logisticsService.queryLogisticsStatus(logisticsNumber);
        stringRedisTemplate.opsForValue().set("scolley34", "222");
        return logisticsStatus.map(status -> ResponseEntity.ok(new ApiResponse<>("success", status))).orElseGet(() -> ResponseEntity.ok(new ApiResponse<>("", null, new ErrorResponse(200, "Logistics number not found"))));
    }

    @GetMapping("/fake")
    public ResponseEntity<ApiResponse<List<LogisticsStatus>>> createFakeLogisticsStatus(@RequestParam("num") String dataCounts) {
        List<LogisticsStatus> fakeLogisticsStatuses = logisticsService.createFakeLogisticsStatus(dataCounts);
        return ResponseEntity.ok(new ApiResponse<>("success", fakeLogisticsStatuses));
    }
}
