import org.example.model.Passenger;
import org.example.model.Aeroplane;
import org.example.model.PassengerService;
import org.example.model.PassengerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class AeroplaneTest {
    private Aeroplane aeroplane;
    private UUID economyPassengerId;
    private Passenger economyPassenger;
    private Passenger businessClassPassenger;
    private Passenger firstClassPassenger;

    private final PassengerService passengerService = new PassengerService();

    @BeforeEach
    void setUp() {
        aeroplane = new Aeroplane();
        economyPassengerId = UUID.randomUUID();
        economyPassenger = new Passenger(
                economyPassengerId,
                "Steve",
                PassengerType.ECONOMY,
                3,
                50.0,
                "Economy Passenger"
        );
        businessClassPassenger = new Passenger(
                UUID.randomUUID(),
                "Phil",
                PassengerType.BUSINESS_CLASS,
                10,
                66.90,
                "Business Class Passenger"
        );
        firstClassPassenger = new Passenger(
                UUID.randomUUID(),
                "Sophie",
                PassengerType.FIRST_CLASS,
                3,
                100.73,
                null
        );
    }

    @Test
    void shouldAddPassengerOnEnter() {
        assertEquals("Welcome Economy Passenger Steve", aeroplane.enter(economyPassenger));
        assertEquals("Welcome Business Class Passenger Phil", aeroplane.enter(businessClassPassenger));
        assertEquals(2, aeroplane.countPassengers());
        assertEquals(1, aeroplane.countPassengersByType(PassengerType.ECONOMY));
        assertEquals(1, aeroplane.countPassengersByType(PassengerType.FIRST_CLASS));
    }

    @Test
    void shouldRemovePassengerOnExit() {
        aeroplane.bulkEnter(economyPassenger, businessClassPassenger);
        assertEquals(2, aeroplane.countPassengers());

        aeroplane.exit(economyPassengerId);
        assertEquals(0, aeroplane.countPassengersByType(PassengerType.ECONOMY));
        assertEquals(1, aeroplane.countPassengers());
        assertEquals(1, aeroplane.countPassengersByType(PassengerType.BUSINESS_CLASS));
    }

    @Test
    void shouldMapPassengersByType() {
        aeroplane.bulkEnter(economyPassenger, businessClassPassenger);

        var result = aeroplane.mapPassengersByType();
        assertEquals(2, result.size());
        assertSame(economyPassenger, result.get(PassengerType.ECONOMY));
        assertSame(businessClassPassenger, result.get(PassengerType.BUSINESS_CLASS));
    }

    @Test
    void shouldOrderPassengersBySize() {
        aeroplane.bulkEnter(economyPassenger, businessClassPassenger, firstClassPassenger);

        var result = aeroplane.orderPassengersByFareDescending();
        assertEquals(PassengerType.ECONOMY, result.get(0).getType());
        assertEquals(PassengerType.BUSINESS_CLASS, result.get(1).getType());
        assertEquals(PassengerType.FIRST_CLASS, result.get(2).getType());
    }

    @Test
    void shouldCountTotalFareOnTheAeroplane() {
        aeroplane.bulkEnter(economyPassenger, businessClassPassenger, firstClassPassenger);

        assertEquals(217.63, aeroplane.totalFare());
    }

    @Test
    void shouldFilterPassengersByType() {
        aeroplane.bulkEnter(economyPassenger, businessClassPassenger, firstClassPassenger);
        var result = passengerService.filterPassengersByType(
                java.util.List.of(economyPassenger, businessClassPassenger, firstClassPassenger),
                PassengerType.ECONOMY
        );
        assertEquals(1, result.size());
        assertEquals(PassengerType.ECONOMY, result.get(0).getType());
    }

    @Test
    void shouldFilterPassengersBySize() {
        aeroplane.bulkEnter(economyPassenger, businessClassPassenger, firstClassPassenger);
        var result = passengerService.filterPassengersByFare(
                java.util.List.of(
                        economyPassenger,
                        businessClassPassenger,
                        firstClassPassenger
                ), 60
        );
        assertEquals(1, result.size());
        assertEquals(3, result.get(0).getLuggageCount());
    }

    @Test
    void shouldConvertToAnyPassengerToFirstClass() {
        var passenger = new Passenger(
                UUID.randomUUID(),
                "Joe",
                PassengerType.ECONOMY,
                null,
                null,
                null
        );
        var result = passengerService.upgradeToFirstClass(passenger);
        assertEquals(PassengerType.FIRST_CLASS, result.getType());
    }

    @Test
    void shouldComputeCorrectTotalCostForACustomerWithLuggage() {
        var passenger = new Passenger(
                UUID.randomUUID(),
                "Joe",
                PassengerType.ECONOMY,
                2,
                45.0,
                null
        );
        var result = passengerService.computeTotalCost(passenger);
        assertEquals(55.0, result);
    }

    @Test
    void shouldComputeCorrectTotalCostForACustomerWithoutLuggage() {
        var passenger = new Passenger(
                UUID.randomUUID(),
                "Joe",
                PassengerType.ECONOMY,
                0,
                45.0,
                null
        );
        var result = passengerService.computeTotalCost(passenger);
        assertEquals(45.0, result);
    }
}