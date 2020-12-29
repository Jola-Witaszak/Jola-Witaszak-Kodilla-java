package com.kodilla.good.patterns.challenges.flightdatabase;

public class Main {
    public static void main(String[] args) {
        FlightDatabase flightDatabase = new FlightDatabase();
        FlightSearchEngine flightSearchEngine = new FlightSearchEngine(flightDatabase);

        try {
            flightSearchEngine.displayFlightsFrom("Warszawa");
            System.out.println();
            flightSearchEngine.displayFlightsTo("Lublin");
            System.out.println("-----------------------");
            flightSearchEngine.displayFlightVia("Warszawa", "Lublin");
            System.out.println("-----------------------");
            flightSearchEngine.displayFlightVia("Warszawa", "Gdansk", "Poznan");
        } catch (Exception e) {
            System.out.println("No flights found");
            e.printStackTrace();
        }
    }
}
