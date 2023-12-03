package com.spring.LogisticsStatusTrackingWebsite.domain.response;

public class FakeLogisticsStatue {

    private String sno;
    private TrackingStatus tracking_status;

    public FakeLogisticsStatue(String sno, TrackingStatus tracking_status) {
        this.sno = sno;
        this.tracking_status = tracking_status;
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
}
