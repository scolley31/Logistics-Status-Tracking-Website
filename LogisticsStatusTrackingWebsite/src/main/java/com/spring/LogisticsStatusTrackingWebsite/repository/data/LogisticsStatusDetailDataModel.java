package com.spring.LogisticsStatusTrackingWebsite.repository.data;

import com.spring.LogisticsStatusTrackingWebsite.domain.response.TrackingStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "logistics_status_detail")
public class LogisticsStatusDetailDataModel {

    @Id
    private Long id;

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


    public LogisticsStatusDetailDataModel(Long id, String date, String time, TrackingStatus status, int locationId, String locationTitle) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.status = status;
        this.locationId = locationId;
        this.locationTitle = locationTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public TrackingStatus getStatus() {
        return status;
    }

    public void setStatus(TrackingStatus status) {
        this.status = status;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationTitle() {
        return locationTitle;
    }

    public void setLocationTitle(String locationTitle) {
        this.locationTitle = locationTitle;
    }
}

