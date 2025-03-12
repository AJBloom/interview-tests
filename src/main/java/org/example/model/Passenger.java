package org.example.model;

import java.util.UUID;

public class Passenger {
    private UUID id;
    private String name;
    private PassengerType type;
    private Integer luggageCount;
    private Double farePrice;
    private String description;
    private String seatNumber;

    public Passenger(UUID id, String name, PassengerType type, Integer luggageCount, Double farePrice, String description, String seatNumber) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.luggageCount = luggageCount;
        this.farePrice = farePrice;
        this.description = description;
        this.seatNumber = seatNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PassengerType getType() {
        return type;
    }

    public Integer getLuggageCount() {
        return luggageCount;
    }

    public Double getFarePrice() {
        return farePrice;
    }

    public String getDescription() {
        return description;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}