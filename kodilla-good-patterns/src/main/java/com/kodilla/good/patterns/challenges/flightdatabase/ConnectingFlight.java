package com.kodilla.good.patterns.challenges.flightdatabase;

import java.util.Objects;

public class ConnectingFlight {
    private final Flight first;
    private final Flight second;

    public ConnectingFlight(final Flight first, final Flight second) {
        this.first = first;
        this.second = second;
    }

    public int getPrice() {
        return first.getPrice() + second.getPrice();
    }

    public int getFlightTime() {
        return first.getFlightTime() + second.getFlightTime();
    }

    @Override
    public String toString() {
        return "Flight from: " + first.getDeparture() + " to: " + second.getArrival() +
                ", with stop at: " + first.getArrival() + ", costs " + getPrice() +
                " and takes " + getFlightTime() + " hours.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectingFlight that = (ConnectingFlight) o;

        if (!Objects.equals(first, that.first)) return false;
        return Objects.equals(second, that.second);
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        return result;
    }
}
