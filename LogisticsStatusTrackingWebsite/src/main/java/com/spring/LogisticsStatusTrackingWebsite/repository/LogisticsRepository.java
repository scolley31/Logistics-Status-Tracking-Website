package com.spring.LogisticsStatusTrackingWebsite.repository;

import com.spring.LogisticsStatusTrackingWebsite.domain.response.LogisticsStatus;
import com.spring.LogisticsStatusTrackingWebsite.repository.data.LogisticsStatueDataModel;
import org.springframework.data.repository.CrudRepository;

public interface LogisticsRepository extends CrudRepository<LogisticsRepository, Long> {

    LogisticsStatueDataModel findById(String logisticsId);

    void save(LogisticsStatueDataModel logisticsStatus);
}
