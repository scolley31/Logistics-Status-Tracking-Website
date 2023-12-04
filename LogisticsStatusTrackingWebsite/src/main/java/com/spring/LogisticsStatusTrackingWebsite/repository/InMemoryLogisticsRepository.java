package com.spring.LogisticsStatusTrackingWebsite.repository;


import com.spring.LogisticsStatusTrackingWebsite.domain.response.LogisticsStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class InMemoryLogisticsRepository {

    HashMap<Long, LogisticsStatus> store = new HashMap<>();

    public LogisticsStatus save(LogisticsStatus logistic) {
        store.put(logistic.getSno(), logistic);
        return logistic;
    }

    public LogisticsStatus findLogisticsById(String logisticsId) {
        return store.get(logisticsId);
    }
}
