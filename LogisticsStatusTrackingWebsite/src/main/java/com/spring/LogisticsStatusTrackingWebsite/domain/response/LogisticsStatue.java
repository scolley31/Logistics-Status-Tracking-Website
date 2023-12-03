package com.spring.LogisticsStatusTrackingWebsite.domain.response;


import lombok.Builder;

@Builder
public class LogisticsStatue {

    private String sno;
    private TrackingStatus tracking_status;
    private String estimated_delivery;
    private LogisticsStatueDetail[] details;
    private Recipient recipient;
    private CurrentLocation current_location;

    public LogisticsStatue(String sno, TrackingStatus tracking_status, String estimated_delivery, LogisticsStatueDetail[] details, Recipient recipient, CurrentLocation current_location) {
        this.sno = sno;
        this.tracking_status = tracking_status;
        this.estimated_delivery = estimated_delivery;
        this.details = details;
        this.recipient = recipient;
        this.current_location = current_location;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
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

    public LogisticsStatueDetail[] getDetails() {
        return details;
    }

    public void setDetails(LogisticsStatueDetail[] details) {
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
