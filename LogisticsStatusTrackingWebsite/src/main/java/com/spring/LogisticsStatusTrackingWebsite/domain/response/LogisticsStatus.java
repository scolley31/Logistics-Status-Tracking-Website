package com.spring.LogisticsStatusTrackingWebsite.domain.response;


import lombok.Builder;

import java.util.UUID;

@Builder
public class LogisticsStatus {

    private long sno;
    private TrackingStatus tracking_status;
    private String estimated_delivery;
    private LogisticsStatusDetail[] details;
    private Recipient recipient;
    private CurrentLocation current_location;

    public LogisticsStatus(long sno, TrackingStatus tracking_status, String estimated_delivery, LogisticsStatusDetail[] details, Recipient recipient, CurrentLocation current_location) {
        this.sno = sno;
        this.tracking_status = tracking_status;
        this.estimated_delivery = estimated_delivery;
        this.details = details;
        this.recipient = recipient;
        this.current_location = current_location;
    }

    public long getSno() {
        return sno;
    }

    public void setSno(long sno) {
        this.sno = sno;
    }

    public TrackingStatus getTracking_status() {
        return tracking_status;
    }

    public void setTracking_status(TrackingStatus tracking_status) {
        this.tracking_status = tracking_status;
    }

    public String getEstimated_delivery() {
        return estimated_delivery;
    }

    public void setEstimated_delivery(String estimated_delivery) {
        this.estimated_delivery = estimated_delivery;
    }

    public LogisticsStatusDetail[] getDetails() {
        return details;
    }

    public void setDetails(LogisticsStatusDetail[] details) {
        this.details = details;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public CurrentLocation getCurrent_location() {
        return current_location;
    }

    public void setCurrent_location(CurrentLocation current_location) {
        this.current_location = current_location;
    }
}
