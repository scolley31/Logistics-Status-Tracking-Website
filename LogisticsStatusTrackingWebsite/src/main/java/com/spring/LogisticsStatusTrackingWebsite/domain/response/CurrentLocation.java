package com.spring.LogisticsStatusTrackingWebsite.domain.response;

import lombok.Builder;

@Builder
public class CurrentLocation {

    private Long location_id;
    private String title;
    private String city;
    private String address;

    public CurrentLocation() {
    }

    public CurrentLocation(Long location_id, String title, String city, String address) {
        this.location_id = location_id;
        this.title = title;
        this.city = city;
        this.address = address;
    }

    public Long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
