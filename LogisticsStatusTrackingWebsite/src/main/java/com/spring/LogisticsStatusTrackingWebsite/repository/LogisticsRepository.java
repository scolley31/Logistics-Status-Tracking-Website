package com.spring.LogisticsStatusTrackingWebsite.repository;

import com.spring.LogisticsStatusTrackingWebsite.domain.response.LogisticsStatus;

import java.util.Optional;

public interface LogisticsRepository {

    LogisticsStatus save(LogisticsStatus logisticsStatus);
    Optional<LogisticsStatus> findById(String id);
}
