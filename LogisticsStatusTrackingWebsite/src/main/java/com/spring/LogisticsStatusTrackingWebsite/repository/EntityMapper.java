package com.spring.LogisticsStatusTrackingWebsite.repository;

import com.spring.LogisticsStatusTrackingWebsite.domain.response.CurrentLocation;
import com.spring.LogisticsStatusTrackingWebsite.domain.response.LogisticsStatus;
import com.spring.LogisticsStatusTrackingWebsite.domain.response.LogisticsStatusDetail;
import com.spring.LogisticsStatusTrackingWebsite.domain.response.Recipient;
import com.spring.LogisticsStatusTrackingWebsite.repository.data.CurrentLocationDataModel;
import com.spring.LogisticsStatusTrackingWebsite.repository.data.LogisticsStatueDataModel;
import com.spring.LogisticsStatusTrackingWebsite.repository.data.LogisticsStatusDetailDataModel;
import com.spring.LogisticsStatusTrackingWebsite.repository.data.RecipientDataModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntityMapper {

    public static LogisticsStatueDataModel mapToEntity(LogisticsStatus logisticsStatus) {

        // Map details
        List<LogisticsStatusDetailDataModel> details = Arrays.stream(logisticsStatus.getDetails())
                .map(EntityMapper::mapToLogisticsStatusDetailDataModel)
                .toList();

        // Map recipient
        RecipientDataModel recipient = mapToCurrentRecipientDataModel(logisticsStatus.getRecipient());

        // Map current location
        CurrentLocationDataModel currentLocation = mapToCurrentLocationDataModel(logisticsStatus.getCurrent_location());


        return new LogisticsStatueDataModel(
                logisticsStatus.getSno(),
                logisticsStatus.getTracking_status(),
                logisticsStatus.getEstimated_delivery(),
                details,
                recipient,
                currentLocation
        );
    }

    public static LogisticsStatusDetailDataModel mapToLogisticsStatusDetailDataModel(LogisticsStatusDetail logisticsStatusDetail) {
        return new LogisticsStatusDetailDataModel(
                logisticsStatusDetail.getId(),
                logisticsStatusDetail.getDate(),
                logisticsStatusDetail.getTime(),
                logisticsStatusDetail.getStatus(),
                logisticsStatusDetail.getLocation_id(),
                logisticsStatusDetail.getLocation_title()
        );
    }

    public static RecipientDataModel mapToCurrentRecipientDataModel(Recipient recipient) {
        return new RecipientDataModel(
                recipient.getId(),
                recipient.getName(),
                recipient.getPhone(),
                recipient.getAddress()
        );
    }

    public static CurrentLocationDataModel mapToCurrentLocationDataModel(CurrentLocation currentLocation) {
        return new CurrentLocationDataModel(
                currentLocation.getLocation_id(),
                currentLocation.getTitle(),
                currentLocation.getCity(),
                currentLocation.getAddress()
        );
    }

    public static LogisticsStatus mapToDomain(LogisticsStatueDataModel logisticsStatueDataModel) {
        // Map details
        List<LogisticsStatusDetail> details = logisticsStatueDataModel.getDetails().stream()
                .map(EntityMapper::mapToLogisticsStatusDetail)
                .toList();

        // Map recipient
        Recipient recipient = mapToRecipient(logisticsStatueDataModel.getRecipient());

        // Map current location
        CurrentLocation currentLocation = mapToCurrentLocation(logisticsStatueDataModel.getCurrentLocation());

        return new LogisticsStatus(
                logisticsStatueDataModel.getSno(),
                logisticsStatueDataModel.getTrackingStatus(),
                logisticsStatueDataModel.getEstimatedDelivery(),
                details.toArray(new LogisticsStatusDetail[0]),
                recipient,
                currentLocation
        );
    }

    public static LogisticsStatusDetail mapToLogisticsStatusDetail(LogisticsStatusDetailDataModel logisticsStatusDetailDataModel) {
        return new LogisticsStatusDetail(
                logisticsStatusDetailDataModel.getId(),
                logisticsStatusDetailDataModel.getDate(),
                logisticsStatusDetailDataModel.getTime(),
                logisticsStatusDetailDataModel.getStatus(),
                logisticsStatusDetailDataModel.getLocationId(),
                logisticsStatusDetailDataModel.getLocationTitle()
        );
    }

    public static Recipient mapToRecipient(RecipientDataModel recipientDataModel) {
        return new Recipient(
                recipientDataModel.getId(),
                recipientDataModel.getName(),
                recipientDataModel.getPhone(),
                recipientDataModel.getAddress()
        );
    }

    public static CurrentLocation mapToCurrentLocation(CurrentLocationDataModel currentLocationDataModel) {
        return new CurrentLocation(
                currentLocationDataModel.getId(),
                currentLocationDataModel.getTitle(),
                currentLocationDataModel.getCity(),
                currentLocationDataModel.getAddress()
        );
    }
}
