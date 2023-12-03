package com.spring.LogisticsStatusTrackingWebsite.repository.data;

import com.spring.LogisticsStatusTrackingWebsite.domain.response.TrackingStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "logistics_statue")
public class LogisticsStatueDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sno")
    private String sno;

    @Enumerated(EnumType.STRING)
    @Column(name = "tracking_status")
    private TrackingStatus trackingStatus;

    @Column(name = "estimated_delivery")
    private String estimatedDelivery;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<LogisticsStatusDetailDataModel> details;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient", referencedColumnName = "id")
    private RecipientDataModel recipient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_location", referencedColumnName = "id")
    private CurrentLocationDataModel currentLocation;

    public LogisticsStatueDataModel(String sno, TrackingStatus trackingStatus, String estimatedDelivery, List<LogisticsStatusDetailDataModel> details, RecipientDataModel recipient, CurrentLocationDataModel currentLocation) {
        this.sno = sno;
        this.trackingStatus = trackingStatus;
        this.estimatedDelivery = estimatedDelivery;
        this.details = details;
        this.recipient = recipient;
        this.currentLocation = currentLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public TrackingStatus getTrackingStatus() {
        return trackingStatus;
    }

    public void setTrackingStatus(TrackingStatus trackingStatus) {
        this.trackingStatus = trackingStatus;
    }

    public String getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(String estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }

    public List<LogisticsStatusDetailDataModel> getDetails() {
        return details;
    }

    public void setDetails(List<LogisticsStatusDetailDataModel> details) {
        this.details = details;
    }

    public RecipientDataModel getRecipient() {
        return recipient;
    }

    public void setRecipient(RecipientDataModel recipient) {
        this.recipient = recipient;
    }

    public CurrentLocationDataModel getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(CurrentLocationDataModel currentLocation) {
        this.currentLocation = currentLocation;
    }
}

