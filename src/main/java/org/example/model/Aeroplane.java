package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Aeroplane {

    private final List<Passenger> passengers = new ArrayList<>();

    public String enter(Passenger passenger)
    {
        throw new UnsupportedOperationException ("Add passenger to passengers list");
        // throw new UnsupportedOperationException ("Print passenger description if it is not null");
        // throw new UnsupportedOperationException ("Print a welcome message for each passenger type, see unit test shouldAddPassengerOnEnter for expected message");
    }

    public List<Passenger> bulkEnter(Passenger... passenger)
    {
        throw new UnsupportedOperationException ("Implement method that executes enter(passenger) for each passenger and return all as list");
    }

    public boolean exit(UUID passengerId)
    {
        throw new UnsupportedOperationException ("Should remove passenger from passenger list returning true on success otherwise false");
    }

    public int countPassengers()
    {
        throw new UnsupportedOperationException ("count passengers in passenger list");
    }

    public int countPassengersByType(PassengerType passengerType)
    {
        throw new UnsupportedOperationException ("count passengers of given passenger type in passenger list");
    }

    public Map<PassengerType, Passenger> mapPassengersByType()
    {
        throw new UnsupportedOperationException ("Convert passenger list to a map keyed by passenger type. If any two elements would have the same key, then the last one gets added to the map");
    }

    public List<Passenger> orderPassengersByFare()
    {
        throw new UnsupportedOperationException ("Return a list of all passengers (from passengers list) sorted in descending order of fare price");
    }

    public int totalFare()
    {
        throw new UnsupportedOperationException ("Return the sum of all passenger fare prices");
    }
}
