package com.spring.LogisticsStatusTrackingWebsite.domain.response;


import lombok.Builder;

import java.util.UUID;

@Builder
public class LogisticsStatusDetail {

    private long id;
    private String date;
    private String time;
    private TrackingStatus status;
    private int location_id;
    private String location_title;

    public LogisticsStatusDetail(long id, String date, String time, TrackingStatus status, int location_id, String location_title) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.status = status;
        this.location_id = location_id;
        this.location_title = location_title;
    }

    public LogisticsStatusDetail() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getLocation_title() {
        return location_title;
    }

    public void setLocation_title(String location_title) {
        this.location_title = location_title;
    }
}
