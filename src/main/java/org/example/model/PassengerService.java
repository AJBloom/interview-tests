package org.example.model;

import java.util.List;

public class PassengerService {

    public List<Passenger> filterPassengersByType(List<Passenger> people, PassengerType... passengerType)
    {
        return filterByType(people, passengerType);
    }

    public List<Passenger> filterPassengersByFare(List<Passenger> people, int sizeFrom)
    {
        return filterByFare(people, sizeFrom);
    }

    public Passenger upgradeToFirstClass(Passenger passenger)
    {
        throw new UnsupportedOperationException ("Implement function that returns a new passenger with upgraded Type");
    }

    public Double computeTotalCost(Passenger passenger)
    {
        throw new UnsupportedOperationException ("Implement function that returns total cost of passenger (fare price + (5 * luggage count))");
    }

    public static List<Passenger> filterByType(List<Passenger> unicorns, PassengerType... passengerType)
    {
        throw new UnsupportedOperationException ("Implement function that filters passengers by given types");
    }

    public static List<Passenger> filterByFare(List<Passenger> unicorns, int fareFrom)
    {
        throw new UnsupportedOperationException ("Implement function that filters passengers by given fareFrom");
    }
}
