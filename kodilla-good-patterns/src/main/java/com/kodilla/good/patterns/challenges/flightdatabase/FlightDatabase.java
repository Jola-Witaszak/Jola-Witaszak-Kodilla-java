package com.kodilla.good.patterns.challenges.flightdatabase;

import java.util.ArrayList;
import java.util.List;

public class FlightDatabase {
    private final List<Flight> directFlights = new ArrayList<>();

    public List<Flight> getFlights() {
        directFlights.add(new Flight("Warszawa", "Krakow", 180, 2));
        directFlights.add(new Flight("Warszawa", "Wroclaw", 280, 3));
        directFlights.add(new Flight("Warszawa", "Szczecin", 300, 4));
        directFlights.add(new Flight("Warszawa", "Poznan", 280, 2));
        directFlights.add(new Flight("Warszawa", "Katowice", 300, 3));
        directFlights.add(new Flight("Krakow", "Gdansk", 550, 3));
        directFlights.add(new Flight("Krakow", "Bydgoszcz", 200, 2));
        directFlights.add(new Flight("Krakow", "Wroclaw", 180, 2));
        directFlights.add(new Flight("Gdansk", "Lublin", 240, 3));
        directFlights.add(new Flight("Poznan", "Olsztyn", 260, 4));
        directFlights.add(new Flight("Szczecin", "Lublin", 330, 4));
        directFlights.add(new Flight("Gdansk", "Radom", 380, 4));
        directFlights.add(new Flight("Krakow", "Lodz", 180, 2));
        directFlights.add(new Flight("Poznan", "Gdansk", 360, 5));
        return new ArrayList<>(directFlights);
    }

    public void addFlight (Flight flight) {
         directFlights.add(flight);
    }

    public boolean removeFlight(Flight flight) {
        return directFlights.remove(flight);
    }

    public void upDateFlight(int index, Flight flight) {
        directFlights.set(index, flight);
    }
}

