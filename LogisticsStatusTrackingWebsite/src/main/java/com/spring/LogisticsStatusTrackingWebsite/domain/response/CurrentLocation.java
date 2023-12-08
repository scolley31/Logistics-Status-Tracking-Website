package com.spring.LogisticsStatusTrackingWebsite.domain.response;

import lombok.Builder;

import java.util.Random;

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

    public static CurrentLocation getRandomeCurrentLocation() {

        CurrentLocation firstCurrentLocation = CurrentLocation.builder()
                .location_id(new Random().nextLong(Long.MAX_VALUE))
                .title("台北物流中心")
                .city("台北市")
                .address("台北市")
                .build();

        CurrentLocation secondCurrentLocation = CurrentLocation.builder()
                .location_id(new Random().nextLong(Long.MAX_VALUE))
                .title("台中物流中心")
                .city("台中市")
                .address("台中市")
                .build();

        CurrentLocation thirdCurrentLocation = CurrentLocation.builder()
                .location_id(new Random().nextLong(Long.MAX_VALUE))
                .title("高雄物流中心")
                .city("高雄市")
                .address("高雄市")
                .build();

        CurrentLocation[] currentLocations = {firstCurrentLocation, secondCurrentLocation, thirdCurrentLocation};
        int pick = new Random().nextInt(currentLocations.length);
        return currentLocations[pick];
    }

}
