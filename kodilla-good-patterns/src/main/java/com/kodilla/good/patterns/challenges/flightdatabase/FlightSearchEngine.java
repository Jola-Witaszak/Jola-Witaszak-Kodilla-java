package com.kodilla.good.patterns.challenges.flightdatabase;

import java.util.*;
import java.util.stream.Collectors;

public class FlightSearchEngine {

    public Set<Flight> findFlightTo(String city, FlightDatabase flightDatabase) {
        return flightDatabase.getFlights().stream()
                .filter(flight -> flight.getArrival().equals(city))
                .collect(Collectors.toSet());
    }

    public Set<Flight> findFlightFrom(String city, FlightDatabase flightDatabase) {
        return flightDatabase.getFlights().stream()
                .filter(directFlight -> directFlight.getDeparture().equals(city))
                .collect(Collectors.toSet());
    }

   public Set<ConnectingFlight> findConnectingFlight(String start, String end, FlightDatabase flightDatabase) {
        Set<Flight> startOfJourney = findFlightFrom(start, flightDatabase);
        Set<Flight> endOfJourney = findFlightTo(end, flightDatabase);

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

    public Set<ConnectingFlight> findFlightVia(String start, String end, String fliesBy, FlightDatabase flightDatabase) {
        Set<Flight> startOfJourney = findFlightFrom(start, flightDatabase);
        Set<Flight> endOfJourney = findFlightTo(end, flightDatabase);

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

    public void displayFlightsTo(String city, FlightDatabase flightDatabase) {
        Set<Flight> result = findFlightTo(city, flightDatabase);
        printFlights(result);
    }

    public void displayFlightsFrom(String city, FlightDatabase flightDatabase) {
        Set<Flight> result = findFlightFrom(city, flightDatabase);
        printFlights(result);
    }

    public void displayConnectingFlight(String start, String end, FlightDatabase flightDatabase) {
        Set<ConnectingFlight> result = findConnectingFlight(start, end, flightDatabase);
        result.forEach(System.out::println);
    }

    public void displayFlightVia(String start, String end, String change, FlightDatabase flightDatabase) {
        Set<ConnectingFlight> result = findFlightVia(start, end, change, flightDatabase);
        result.forEach(System.out::println);
    }
}
