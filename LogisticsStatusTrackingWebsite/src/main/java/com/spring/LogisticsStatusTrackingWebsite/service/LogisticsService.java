package com.spring.LogisticsStatusTrackingWebsite.service;


import com.spring.LogisticsStatusTrackingWebsite.domain.response.*;
import com.spring.LogisticsStatusTrackingWebsite.repository.InMemoryLogisticsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LogisticsService {

    private final InMemoryLogisticsRepository repository;

    public LogisticsService(InMemoryLogisticsRepository repository) {
        this.repository = repository;
    }

    public LogisticsStatue queryLogisticsStatus(String logisticsNumber) {
        return repository.findLogisticsById(logisticsNumber);
    }

    public List<LogisticsStatue> createFakeLogisticsStatus(String dataCounts) {
        List<LogisticsStatue> fakeLogisticsStatues = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(dataCounts); i++) {
            LogisticsStatue logisticsStatue = createLogisticsStatus();
            repository.save(logisticsStatue);
            fakeLogisticsStatues.add(logisticsStatue);
        }
        return fakeLogisticsStatues;
    }

    public static LogisticsStatue createLogisticsStatus() {
        return LogisticsStatue.builder()
                .sno(String.valueOf(new Random().nextInt(100000000)))
                .tracking_status(TrackingStatus.CREATED)
                .estimated_delivery("2021-05-20")
                .details(new LogisticsStatueDetail[]{
                        LogisticsStatueDetail.builder()
                                .id(1)
                                .date("2021-05-20")
                                .time("10:00:00")
                                .status(TrackingStatus.CREATED)
                                .location_id(1)
                                .location_title("台北市")
                                .build(),
                        LogisticsStatueDetail.builder()
                                .id(1)
                                .date("2021-05-20")
                                .time("10:00:00")
                                .status(TrackingStatus.CREATED)
                                .location_id(1)
                                .location_title("台北市")
                                .build(),
                        LogisticsStatueDetail.builder()
                                .id(1)
                                .date("2021-05-20")
                                .time("10:00:00")
                                .status(TrackingStatus.CREATED)
                                .location_id(1)
                                .location_title("台北市")
                                .build(),
                        LogisticsStatueDetail.builder()
                                .id(1)
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
                        .location_id(1)
                        .title("台北市")
                        .city("台北市")
                        .address("台北市")
                        .build())
                .build();
    }

}
