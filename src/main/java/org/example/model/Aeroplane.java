package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Aeroplane {

    private final List<Passenger> passengers = new ArrayList<>();
    private static UnsupportedOperationException todo(String message) {
        return new UnsupportedOperationException(message);
    }

    public String enter(Passenger passenger)
    {
        throw todo("Add passenger to passengers list");
        // throw new UnsupportedOperationException ("Print passenger description if it is not null");
        // throw new UnsupportedOperationException ("Print a welcome message for each passenger type, see unit test shouldAddPassengerOnEnter for expected message");
    }

    public List<Passenger> bulkEnter(Passenger... passenger)
    {
        throw todo("Implement method that executes enter(passenger) for each passenger and return all as list");
    }

    public boolean exit(UUID passengerId)
    {
        throw todo("Should remove passenger from passenger list returning true on success otherwise false");
    }

    public int countPassengers()
    {
        throw todo("count passengers in passenger list");
    }

    public int countPassengersByType(PassengerType passengerType)
    {
        throw todo("count passengers of given passenger type in passenger list");
    }

    public Map<PassengerType, Passenger> mapPassengersByType()
    {
        throw todo("Convert passenger list to a map keyed by passenger type. If any two elements would have the same key, then the last one gets added to the map");
    }

    public List<Passenger> orderPassengersByFare()
    {
        throw todo("Return a list of all passengers (from passengers list) sorted in descending order of fare price");
    }

    public int totalFare()
    {
        throw todo("Return the sum of all passenger fare prices");
    }
}
