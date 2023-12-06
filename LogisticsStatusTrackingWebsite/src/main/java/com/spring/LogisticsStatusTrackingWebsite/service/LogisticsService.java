package com.spring.LogisticsStatusTrackingWebsite.service;


import com.spring.LogisticsStatusTrackingWebsite.domain.response.*;
import com.spring.LogisticsStatusTrackingWebsite.repository.LogisticsRepositoryImpl;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class LogisticsService {

    private final LogisticsRepositoryImpl logisticsRepository;
    private final RedisTemplate<String, String> redisTemplate;

    @Resource(name="redisTemplate")
    private ListOperations<Long, String> listOps;

    public LogisticsService(LogisticsRepositoryImpl logisticsRepository, RedisTemplate<String, String> redisTemplate) {
        this.logisticsRepository = logisticsRepository;
        this.redisTemplate = redisTemplate;
    }

    public Optional<LogisticsStatus> queryLogisticsStatus(String logisticsNumber) {
        return logisticsRepository.findById(logisticsNumber);
    }

    public List<LogisticsStatus> createFakeLogisticsStatus(String dataCounts) {
        List<LogisticsStatus> fakeLogisticsStatuses = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(dataCounts); i++) {
            LogisticsStatus logisticsStatus = createLogisticsStatus();
            listOps.leftPush(logisticsStatus.getSno(), logisticsStatus.toString());
            LogisticsStatus saveLogisticsStatus = logisticsRepository.save(logisticsStatus);
            fakeLogisticsStatuses.add(saveLogisticsStatus);
        }
        return fakeLogisticsStatuses;
    }

    public static LogisticsStatus createLogisticsStatus() {
        return LogisticsStatus.builder()
                .tracking_status(TrackingStatus.CREATED)
                .estimated_delivery("2021-05-20")
                .details(new LogisticsStatusDetail[]{
                        LogisticsStatusDetail.builder()
                                .date("2021-05-20")
                                .time("10:00:00")
                                .status(TrackingStatus.CREATED)
                                .location_id(1)
                                .location_title("台北市")
                                .build(),
                        LogisticsStatusDetail.builder()
                                .date("2021-05-20")
                                .time("10:00:00")
                                .status(TrackingStatus.CREATED)
                                .location_id(1)
                                .location_title("台北市")
                                .build(),
                        LogisticsStatusDetail.builder()
                                .date("2021-05-20")
                                .time("10:00:00")
                                .status(TrackingStatus.CREATED)
                                .location_id(1)
                                .location_title("台北市")
                                .build(),
                        LogisticsStatusDetail.builder()
                                .date("2021-05-20")
                                .time("10:00:00")
                                .status(TrackingStatus.CREATED)
                                .location_id(1)
                                .location_title("台北市")
                                .build(),
                })
                .recipient(Recipient.builder()
                        .name("王小明")
                        .phone("0912345678")
                        .address("台北市")
                        .build())
                .current_location(CurrentLocation.builder()
                        .location_id(new Random().nextLong(Long.MAX_VALUE))
                        .title("台北市")
                        .city("台北市")
                        .address("台北市")
                        .build())
                .build();
    }

}
