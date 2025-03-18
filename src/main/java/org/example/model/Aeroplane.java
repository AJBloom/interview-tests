package org.example.model;

import java.util.*;

public class Aeroplane {

    private final List<Passenger> passengers = new ArrayList<>();

    public String enter(Passenger passenger) {
        passengers.add(passenger);
        return "Welcome " + passenger.getDescription() + " " + passenger.getName();
    }

    public List<Passenger> bulkEnter(Passenger... passenger) {
        passengers.addAll(Arrays.asList(passenger));
        return passengers;
    }

    public boolean exit(UUID passengerId) {
        return passengers.removeIf(passenger -> passenger.getId().equals(passengerId));
    }

    public int countPassengers() {
        return passengers.size();
    }

    public int countPassengersByType(PassengerType passengerType) {
        return (int) passengers.stream().filter(
                passenger -> passenger.getType().equals(passengerType)
        ).count();
    }

    public Map<PassengerType, Passenger> mapPassengersByType() {
        Map<PassengerType, Passenger> passengerMap = new HashMap<>();
        for (Passenger passenger : passengers) {
            passengerMap.put(passenger.getType(), passenger);
        }
        return passengerMap;
    }

    public List<Passenger> orderPassengersByFare() {
        return passengers.stream()
                .sorted(Comparator.comparingDouble(Passenger::getFarePrice))
                .toList();
    }

    public double totalFare() {
        return passengers.stream()
                .mapToDouble(Passenger::getFarePrice)
                .sum();
    }
}
