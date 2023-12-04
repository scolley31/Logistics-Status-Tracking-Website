package com.spring.LogisticsStatusTrackingWebsite.repository.data;

import com.spring.LogisticsStatusTrackingWebsite.domain.response.TrackingStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity
@Table(name = "logistics_status_detail")
public class LogisticsStatusDetailDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TrackingStatus status;

    @Column(name = "location_id")
    private int locationId;

    @Column(name = "location_title")
    private String locationTitle;


    public LogisticsStatusDetailDataModel(String date, String time, TrackingStatus status, int locationId, String locationTitle) {
        this.date = date;
        this.time = time;
        this.status = status;
        this.locationId = locationId;
        this.locationTitle = locationTitle;
    }

    public LogisticsStatusDetailDataModel() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setStatus(TrackingStatus status) {
        this.status = status;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public void setLocationTitle(String locationTitle) {
        this.locationTitle = locationTitle;
    }
}

