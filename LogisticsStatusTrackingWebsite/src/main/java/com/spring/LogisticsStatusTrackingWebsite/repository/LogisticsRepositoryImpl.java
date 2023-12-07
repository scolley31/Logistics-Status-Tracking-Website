package com.spring.LogisticsStatusTrackingWebsite.repository;

import com.spring.LogisticsStatusTrackingWebsite.domain.response.LogisticsStatus;
import com.spring.LogisticsStatusTrackingWebsite.repository.data.LogisticsStatueDataModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class LogisticsRepositoryImpl implements LogisticsRepository {

    private final LogisticsDao logisticsDao;

    @Override
    public LogisticsStatus save(LogisticsStatus logisticsStatus) {
        LogisticsStatueDataModel dataModel = EntityMapper.mapToEntity(logisticsStatus);
        logisticsDao.save(dataModel);
        return EntityMapper.mapToDomain(dataModel);
    }

    @Override
    public Optional<LogisticsStatus> findById(String id) {
        return logisticsDao.findById(Long.valueOf(id)).map(EntityMapper::mapToDomain);
    }


}
