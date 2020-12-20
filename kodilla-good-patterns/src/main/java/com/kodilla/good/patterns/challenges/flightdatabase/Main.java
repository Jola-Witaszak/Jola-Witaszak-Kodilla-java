package com.kodilla.good.patterns.challenges.flightdatabase;

public class Main {
    public static void main(String[] args) {

        FlightSearchEngine flightSearchEngine = new FlightSearchEngine();
        FlightDatabase flightDatabase = new FlightDatabase();

        try {
            flightSearchEngine.displayFlightsFrom("Warszawa", flightDatabase);
            System.out.println();
            flightSearchEngine.displayFlightsTo("Lublin", flightDatabase);
            System.out.println("-----------------------");
            flightSearchEngine.displayConnectingFlight("Warszawa", "Lublin", flightDatabase);
            System.out.println("-----------------------");
            flightSearchEngine.displayFlightVia("Warszawa", "Gdansk", "Poznan", flightDatabase);
        } catch (Exception e) {
            System.out.println("No flights found");
            e.printStackTrace();
        }
    }
}
