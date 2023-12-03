package com.spring.LogisticsStatusTrackingWebsite.service;


import com.spring.LogisticsStatusTrackingWebsite.domain.response.*;
import com.spring.LogisticsStatusTrackingWebsite.repository.EntityMapper;
import com.spring.LogisticsStatusTrackingWebsite.repository.LogisticsRepository;
import com.spring.LogisticsStatusTrackingWebsite.repository.data.LogisticsStatueDataModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LogisticsService {

    private final LogisticsRepository logisticsRepository;

    public LogisticsService(LogisticsRepository logisticsRepository) {
        this.logisticsRepository = logisticsRepository;
    }

    public LogisticsStatus queryLogisticsStatus(String logisticsNumber) {
        LogisticsStatueDataModel logisticsStatueDataModel = logisticsRepository.findById(logisticsNumber);
        return EntityMapper.mapToDomain(logisticsStatueDataModel);
    }

    public List<LogisticsStatus> createFakeLogisticsStatus(String dataCounts) {
        List<LogisticsStatus> fakeLogisticsStatuses = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(dataCounts); i++) {
            LogisticsStatus logisticsStatus = createLogisticsStatus();
            LogisticsStatueDataModel logisticsStatueDataModel = EntityMapper.mapToEntity(logisticsStatus);
            logisticsRepository.save(logisticsStatueDataModel);
            fakeLogisticsStatuses.add(logisticsStatus);
        }
        return fakeLogisticsStatuses;
    }

    public static LogisticsStatus createLogisticsStatus() {
        return LogisticsStatus.builder()
                .sno(String.valueOf(new Random().nextInt(100000000)))
                .tracking_status(TrackingStatus.CREATED)
                .estimated_delivery("2021-05-20")
                .details(new LogisticsStatusDetail[]{
                        LogisticsStatusDetail.builder()
                                .id(1L)
                                .date("2021-05-20")
                                .time("10:00:00")
                                .status(TrackingStatus.CREATED)
                                .location_id(1)
                                .location_title("台北市")
                                .build(),
                        LogisticsStatusDetail.builder()
                                .id(1L)
                                .date("2021-05-20")
                                .time("10:00:00")
                                .status(TrackingStatus.CREATED)
                                .location_id(1)
                                .location_title("台北市")
                                .build(),
                        LogisticsStatusDetail.builder()
                                .id(1L)
                                .date("2021-05-20")
                                .time("10:00:00")
                                .status(TrackingStatus.CREATED)
                                .location_id(1)
                                .location_title("台北市")
                                .build(),
                        LogisticsStatusDetail.builder()
                                .id(1L)
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
                        .location_id(1L)
                        .title("台北市")
                        .city("台北市")
                        .address("台北市")
                        .build())
                .build();
    }

}
