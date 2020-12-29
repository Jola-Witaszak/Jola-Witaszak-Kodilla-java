package com.kodilla.good.patterns.challenges.flightdatabase;

import java.util.*;
import java.util.stream.Collectors;

public class FlightSearchEngine {
    FlightDatabase flightDatabase;

    public FlightSearchEngine(FlightDatabase flightDatabase) {
        this.flightDatabase = flightDatabase;
    }

    public Set<Flight> findFlightTo(String city) {
        return flightDatabase.getFlights().stream()
                .filter(flight -> flight.getArrival().equals(city))
                .collect(Collectors.toSet());
    }

    public Set<Flight> findFlightFrom(String city) {
        return flightDatabase.getFlights().stream()
                .filter(directFlight -> directFlight.getDeparture().equals(city))
                .collect(Collectors.toSet());
    }

    public Set<ConnectingFlight> findFlightVia(String start, String end) {
        Set<Flight> startOfJourney = findFlightFrom(start);
        Set<Flight> endOfJourney = findFlightTo(end);

        Set<ConnectingFlight> result = new HashSet<>();

        for (Flight first : startOfJourney) {
            for (Flight second : endOfJourney) {
                if (first.getArrival().equals(second.getDeparture())) {
                    result.add(new ConnectingFlight(first, second));
                }
            }
        }
        return result;
    }

    public Set<ConnectingFlight> findFlightVia(String start, String end, String fliesBy) {
        Set<Flight> startOfJourney = findFlightFrom(start);
        Set<Flight> endOfJourney = findFlightTo(end);

        Set<ConnectingFlight> result = new HashSet<>();
        for (Flight first : startOfJourney) {
            for (Flight second : endOfJourney) {
                if (first.getArrival().equals(fliesBy) && second.getDeparture().equals(fliesBy)) {
                    result.add(new ConnectingFlight(first, second));
                }
            }
        }
        return result;
    }

    public void printFlights(Set<Flight> flights) {
        flights.forEach(System.out::println);
    }

    public void displayFlightsTo(String city) {
        Set<Flight> result = findFlightTo(city);
        printFlights(result);
    }

    public void displayFlightsFrom(String city) {
        Set<Flight> result = findFlightFrom(city);
        printFlights(result);
    }

    public void displayFlightVia(String start, String end) {
        Set<ConnectingFlight> result = findFlightVia(start, end);
        result.forEach(System.out::println);
    }

    public void displayFlightVia(String start, String end, String change) {
        Set<ConnectingFlight> result = findFlightVia(start, end, change);
        result.forEach(System.out::println);
    }
}