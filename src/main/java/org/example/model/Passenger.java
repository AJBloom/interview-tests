package org.example.model;

import java.util.UUID;

public class Passenger {
    private UUID id;
    private String name;
    private PassengerType type;
    private Integer luggageCount;
    private Double farePrice;
    private String description;

    public Passenger(UUID id, String name, PassengerType type, Integer luggageCount, Double farePrice, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.luggageCount = luggageCount;
        this.farePrice = farePrice;
        this.description = description;
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
}