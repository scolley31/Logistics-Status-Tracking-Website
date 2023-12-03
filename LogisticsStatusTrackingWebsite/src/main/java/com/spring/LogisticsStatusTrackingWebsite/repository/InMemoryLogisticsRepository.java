package com.spring.LogisticsStatusTrackingWebsite.repository;


import com.spring.LogisticsStatusTrackingWebsite.domain.response.LogisticsStatue;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class InMemoryLogisticsRepository {

    HashMap<String, LogisticsStatue> store = new HashMap<>();

    public LogisticsStatue save(LogisticsStatue logistic) {
        store.put(logistic.getSno(), logistic);
        return logistic;
    }

    public LogisticsStatue findLogisticsById(String logisticsId) {
        return store.get(logisticsId);
    }
}
