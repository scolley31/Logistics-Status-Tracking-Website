package com.spring.LogisticsStatusTrackingWebsite.repository.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "current_location")
public class CurrentLocationDataModel {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    public CurrentLocationDataModel(Long id, String title, String city, String address) {
        this.id = id;
        this.title = title;
        this.city = city;
        this.address = address;
    }

    public CurrentLocationDataModel() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
