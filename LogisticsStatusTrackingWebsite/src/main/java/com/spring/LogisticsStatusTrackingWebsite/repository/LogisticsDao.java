package com.spring.LogisticsStatusTrackingWebsite.repository;

import com.spring.LogisticsStatusTrackingWebsite.repository.data.LogisticsStatueDataModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LogisticsDao extends CrudRepository<LogisticsStatueDataModel, Long> {


}
