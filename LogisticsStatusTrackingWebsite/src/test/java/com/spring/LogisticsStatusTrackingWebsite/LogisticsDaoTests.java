package com.spring.LogisticsStatusTrackingWebsite;

import com.spring.LogisticsStatusTrackingWebsite.domain.response.LogisticsStatus;
import com.spring.LogisticsStatusTrackingWebsite.repository.EntityMapper;
import com.spring.LogisticsStatusTrackingWebsite.repository.LogisticsDao;
import com.spring.LogisticsStatusTrackingWebsite.repository.data.LogisticsStatueDataModel;
import com.spring.LogisticsStatusTrackingWebsite.service.LogisticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class LogisticsDaoTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LogisticsDao repository;


//    @Test
//    public void testFindById() {
//        LogisticsStatus logisticsStatus = LogisticsService.createLogisticsStatus();
//        LogisticsStatueDataModel logisticsStatueDataModel = EntityMapper.mapToEntity(logisticsStatus);
//        entityManager.persist(logisticsStatueDataModel);
//        LogisticsStatueDataModel saveLogisticsStatus = repository.findById(logisticsStatus.getSno());
//        assertThat(saveLogisticsStatus.getSno()).isEqualTo(logisticsStatueDataModel.getSno());
//    }
}
