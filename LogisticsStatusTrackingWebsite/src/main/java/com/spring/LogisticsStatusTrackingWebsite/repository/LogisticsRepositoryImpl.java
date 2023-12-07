package com.spring.LogisticsStatusTrackingWebsite.repository;

import com.spring.LogisticsStatusTrackingWebsite.domain.response.LogisticsStatus;
import com.spring.LogisticsStatusTrackingWebsite.repository.data.LogisticsStatueDataModel;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class LogisticsRepositoryImpl implements LogisticsRepository{

    private final LogisticsDao logisticsDao;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource(name="redisCache")
    private ListOperations<String, String> listOps;

    @Override
    public LogisticsStatus save(LogisticsStatus logisticsStatus) {
        LogisticsStatueDataModel dataModel = EntityMapper.mapToEntity(logisticsStatus);
        logisticsDao.save(dataModel);
        return EntityMapper.mapToDomain(dataModel);
    }

    @Override
    public Optional<LogisticsStatus> findById(String id) {
//        listOps.leftPush("logistics", id);
        redisTemplate.boundListOps("logistics").leftPush(id);
        return logisticsDao.findById(Long.valueOf(id)).map(EntityMapper::mapToDomain);
    }


}
