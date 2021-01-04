package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchEngine {

    public static void main(String[] args) {
        Flight flight1 = new Flight("Warsaw", "Madrid");
        try {
            FlightSearchEngine.findFlight(flight1);
        } catch (RouteNotFoundException e) {
            System.out.println(e);
        }

    }

    public static void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> departures = new HashMap<>();
        departures.put("Berlin", true);
        departures.put("Tokyo", true);
        departures.put("Kathmandu", false);
        departures.put("Warsaw", true);
        departures.put("Paris", true);
        departures.put("Ankara", false);
        departures.put("Madrid", false);
        departures.put("New York", true);
        departures.put("Rome", true);
        departures.put("Vienna", false);
        departures.put("Athens", false);

        for (Map.Entry<String, Boolean> entry : departures.entrySet()) {
            if (entry.getKey().equals(flight.getDepartureAirport())){
                if (entry.getValue()) {
                    System.out.println("Found a flight to " + flight.getDepartureAirport());
                } else {
                    throw new RouteNotFoundException("No flight found to " + flight.getDepartureAirport());
                }
            }
        }
    }
}
