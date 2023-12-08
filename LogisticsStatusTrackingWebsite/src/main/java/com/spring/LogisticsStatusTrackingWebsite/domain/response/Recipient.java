package com.spring.LogisticsStatusTrackingWebsite.domain.response;

import lombok.Builder;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Builder
public class Recipient {

    private UUID id;
    private String name;
    private String address;
    private String phone;

    public Recipient() {
    }

    public Recipient(UUID id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static Recipient getRandomeRecipient() {
        Recipient firstRecipient = Recipient.builder()
                .name("賴清德")
                .phone("0912345678")
                .address("台北市")
                .build();

        Recipient secondRecipient = Recipient.builder()
                .name("陳建仁")
                .phone("0912345678")
                .address("屏東市")
                .build();

        Recipient thirdRecipient = Recipient.builder()
                .name("蘇貞昌")
                .phone("092234123")
                .address("新北市")
                .build();

        Recipient fourthRecipient = Recipient.builder()
                .name("蘇嘉全")
                .phone("0912345678")
                .address("台中市")
                .build();

        Recipient fifthRecipient = Recipient.builder()
                .name("黃振賢")
                .phone("0978763862")
                .address("天龍國")
                .build();

        Recipient sixthRecipient = Recipient.builder()
                .name("蔡英文")
                .phone("0923345678")
                .address("台北市")
                .build();

        List<Recipient> recipients = List.of(firstRecipient, secondRecipient, thirdRecipient, fourthRecipient, fifthRecipient, sixthRecipient);


        int pick = new Random().nextInt(recipients.size());
        return recipients.get(pick);
    }
}
