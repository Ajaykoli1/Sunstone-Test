package Sunstone_Training;

abstract class Flight {    
    int flightNumber;
    String origin;
    String destination;
    double baseFare;

    public Flight(int flightNumber, String origin, String destination, double baseFare) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.baseFare = baseFare;
    }

    abstract double calculateFare();

    void displayDetails() {
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Origin: " + origin);
        System.out.println("Destination: " + destination);
        System.out.println("Base Fare: " + baseFare);
        System.out.println("Total Fare: " + calculateFare());
    }
}

class DomesticFlight extends Flight {
    final double DOMESTIC_TAX = 0.10;

    public DomesticFlight(int flightNumber, String origin, String destination, double baseFare) {
        super(flightNumber, origin, destination, baseFare);
    }

    @Override
    double calculateFare() {
        return baseFare + (baseFare * DOMESTIC_TAX);
    }
}

class InternationalFlight extends Flight {
    final double INTERNATIONAL_TAX = 0.20;
    double immigrationFee;

    public InternationalFlight(int flightNumber, String origin, String destination, double baseFare, double immigrationFee) {
        super(flightNumber, origin, destination, baseFare);
        this.immigrationFee = immigrationFee;
    }

    @Override
    double calculateFare() {
        return baseFare + (baseFare * INTERNATIONAL_TAX) + immigrationFee;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Immigration Fee: " + immigrationFee);
    }
}

public class FlightManager {
    public static void main(String[] args) {
        Flight[] flights = new Flight[2];
        flights[0] = new DomesticFlight(101, "Delhi", "Mumbai", 5000);
        flights[1] = new InternationalFlight(201, "Delhi", "London", 20000, 3000);

        for (Flight f : flights) {
            f.displayDetails();
            System.out.println("----------------------");
        }
    }
}