package com.kodilla.good.patterns.challenges.flightdatabase;

public class Flight {
    private final String departure;
    private final String arrival;
    private final int price;
    private final int flightTime;

    public Flight(final String departure, final String arrival, final int price, final int flightTime) {
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.flightTime = flightTime;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Flight from: " + getDeparture() + " to: " + getArrival() +
                " costs " + getPrice() + " and takes " + getFlightTime() + " hours.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight that = (Flight) o;

        if (getPrice() != that.getPrice()) return false;
        if (getFlightTime() != that.getFlightTime()) return false;
        if (!getDeparture().equals(that.getDeparture())) return false;
        return getArrival().equals(that.getArrival());
    }

    @Override
    public int hashCode() {
        int result = getDeparture().hashCode();
        result = 31 * result + getArrival().hashCode();
        return result;
    }
}
