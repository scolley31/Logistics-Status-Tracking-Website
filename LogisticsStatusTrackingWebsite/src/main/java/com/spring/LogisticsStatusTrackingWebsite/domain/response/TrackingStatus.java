package com.spring.LogisticsStatusTrackingWebsite.domain.response;

public enum TrackingStatus {

    CREATED("Created"),

    PACKAGE_RECEIVED("Package Received"),
    IN_TRANSIT("In Transit"),
    OUT_FOR_DELIVERY("Out for Delivery"),
    DELIVERED("Delivered"),
    RETURNED_TO_SENDER("Returned to Sender"),
    EXCEPTION("Exception");
    private String status;

    TrackingStatus(String status) {
        this.status = status;
    }
}
