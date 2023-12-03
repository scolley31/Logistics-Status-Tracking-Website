package com.spring.LogisticsStatusTrackingWebsite.controller;


import com.spring.LogisticsStatusTrackingWebsite.domain.response.ApiResponse;
import com.spring.LogisticsStatusTrackingWebsite.domain.response.ErrorResponse;
import com.spring.LogisticsStatusTrackingWebsite.domain.response.FakeLogisticsStatue;
import com.spring.LogisticsStatusTrackingWebsite.domain.response.LogisticsStatue;
import com.spring.LogisticsStatusTrackingWebsite.service.LogisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logistics")
public class LogisticsController {

    private final LogisticsService logisticsService;

    public LogisticsController(LogisticsService logisticsService) {
        this.logisticsService = logisticsService;
    }

    @GetMapping("/query")
    public ResponseEntity<ApiResponse<LogisticsStatue>> queryLogisticsStatus(@RequestParam("sno") String logisticsNumber) {
        LogisticsStatue logisticsStatue = logisticsService.queryLogisticsStatus(logisticsNumber);
        if (logisticsStatue == null) {
            return ResponseEntity.ok(new ApiResponse<>("", null, new ErrorResponse(200, "Logistics number not found")));
        }
        return ResponseEntity.ok(new ApiResponse<>("success", logisticsStatue));
    }

    @GetMapping("/fake")
    public ResponseEntity<ApiResponse<List<LogisticsStatue>>> createFakeLogisticsStatus(@RequestParam("num") String dataCounts) {
        List<LogisticsStatue> fakeLogisticsStatues = logisticsService.createFakeLogisticsStatus(dataCounts);
        return ResponseEntity.ok(new ApiResponse<>("success", fakeLogisticsStatues));
    }
}
