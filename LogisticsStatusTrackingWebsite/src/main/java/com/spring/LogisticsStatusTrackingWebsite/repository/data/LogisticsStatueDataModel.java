package com.spring.LogisticsStatusTrackingWebsite.repository.data;

import com.spring.LogisticsStatusTrackingWebsite.domain.response.TrackingStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "logistics_statue")
public class LogisticsStatueDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sno;

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

    public LogisticsStatueDataModel(TrackingStatus trackingStatus, String estimatedDelivery, List<LogisticsStatusDetailDataModel> details, RecipientDataModel recipient, CurrentLocationDataModel currentLocation) {
        this.trackingStatus = trackingStatus;
        this.estimatedDelivery = estimatedDelivery;
        this.details = details;
        this.recipient = recipient;
        this.currentLocation = currentLocation;
    }

    public LogisticsStatueDataModel() {
    }

    public void setTrackingStatus(TrackingStatus trackingStatus) {
        this.trackingStatus = trackingStatus;
    }

    public void setEstimatedDelivery(String estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }

    public void setDetails(List<LogisticsStatusDetailDataModel> details) {
        this.details = details;
    }

    public void setRecipient(RecipientDataModel recipient) {
        this.recipient = recipient;
    }

    public void setCurrentLocation(CurrentLocationDataModel currentLocation) {
        this.currentLocation = currentLocation;
    }
}

