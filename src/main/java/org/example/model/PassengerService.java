package org.example.model;

import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class PassengerService {

    public List<Passenger> filterPassengersByType(List<Passenger> people, PassengerType... passengerType) {
        return filterByType(people, passengerType);
    }

    public List<Passenger> filterPassengersByFareAsInt(List<Passenger> people, int fareFrom) {
        return people.stream()
                .filter(passenger -> passenger.getFarePrice() <= fareFrom)
                .collect(Collectors.toList());
    }

    public Passenger upgradeToFirstClass(Passenger passenger) {
        return new Passenger(
                passenger.getId(),
                passenger.getName(),
                PassengerType.FIRST_CLASS,
                passenger.getLuggageCount(),
                passenger.getFarePrice(),
                passenger.getDescription(),
                passenger.getSeatNumber()
        );
    }

    public Double computeTotalCost(Passenger passenger) {
        double luggageCost = passenger.getLuggageCount() * 5;
        return passenger.getFarePrice() + luggageCost;
    }

    public List<Passenger> filterByType(List<Passenger> passengers, PassengerType... passengerTypes) {
        List<PassengerType> types = List.of(passengerTypes);
        return passengers.stream()
                .filter(passenger -> types.contains(passenger.getType()))
                .collect(Collectors.toList());
    }

    public List<Passenger> filterByFare(List<Passenger> passengers, int fareFrom) {
        return passengers.stream()
                .filter(passenger -> passenger.getFarePrice() >= fareFrom)
                .collect(Collectors.toList());
    }

    public PassengerType findMostCommonPassengerType(List<Passenger> passengers) {
        return passengers.stream()
                .collect(Collectors.groupingBy(Passenger::getType, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public int boardOrder(Passenger passenger) {
        return switch (passenger.getType()) {
            case FIRST_CLASS -> 1;
            case BUSINESS_CLASS -> 2;
            case ECONOMY -> 3;
        };
    }

    public List<Passenger> sortBySeatNumber(List<Passenger> passengers) {
        return passengers.stream()
                .sorted(Comparator.comparing(passenger -> {
                    String seatNumber = passenger.getSeatNumber();
                    int numberPart = Integer.parseInt(seatNumber.replaceAll("[^0-9]", ""));
                    String letterPart = seatNumber.replaceAll("[0-9]", "");
                    return new SeatNumber(numberPart, letterPart);
                }))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list;
                }));
    }

    private static class SeatNumber implements Comparable<SeatNumber> {
        private final int numberPart;
        private final String letterPart;

        public SeatNumber(int numberPart, String letterPart) {
            this.numberPart = numberPart;
            this.letterPart = letterPart;
        }

        @Override
        public int compareTo(SeatNumber other) {
            int numberComparison = Integer.compare(this.numberPart, other.numberPart);
            if (numberComparison != 0) {
                return numberComparison;
            }
            return this.letterPart.compareTo(other.letterPart);
        }
    }

    public UUID findPassengerIdBySeatNumber(List<Passenger> passengers, String seatNumber) {
        return passengers.stream()
                .filter(passenger -> passenger.getSeatNumber().equals(seatNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No passenger found with seat number: " + seatNumber))
                .getId();
    }

    public UUID findPassengerIdWithLowestSeatNumber(List<Passenger> passengers) {
        List<Passenger> reverseList = sortBySeatNumber(passengers);
        return reverseList.get(reverseList.size() -1).getId();
    }
}
