package com.spring.LogisticsStatusTrackingWebsite.controller;


import com.spring.LogisticsStatusTrackingWebsite.domain.response.ApiResponse;
import com.spring.LogisticsStatusTrackingWebsite.domain.response.ErrorResponse;
import com.spring.LogisticsStatusTrackingWebsite.domain.response.LogisticsStatus;
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
    public ResponseEntity<ApiResponse<LogisticsStatus>> queryLogisticsStatus(@RequestParam("sno") String logisticsNumber) {
        LogisticsStatus logisticsStatus = logisticsService.queryLogisticsStatus(logisticsNumber);
        if (logisticsStatus == null) {
            return ResponseEntity.ok(new ApiResponse<>("", null, new ErrorResponse(200, "Logistics number not found")));
        }
        return ResponseEntity.ok(new ApiResponse<>("success", logisticsStatus));
    }

    @GetMapping("/fake")
    public ResponseEntity<ApiResponse<List<LogisticsStatus>>> createFakeLogisticsStatus(@RequestParam("num") String dataCounts) {
        List<LogisticsStatus> fakeLogisticsStatuses = logisticsService.createFakeLogisticsStatus(dataCounts);
        return ResponseEntity.ok(new ApiResponse<>("success", fakeLogisticsStatuses));
    }
}
