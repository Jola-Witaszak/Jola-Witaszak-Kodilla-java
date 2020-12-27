package com.kodilla.exception.test;

public class Flight {
    private String arrivalAirport;
    private String departureAirport;

    public Flight(String arrivalAirport, String departureAirport) {
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!getArrivalAirport().equals(flight.getArrivalAirport())) return false;
        return getDepartureAirport().equals(flight.getDepartureAirport());
    }

    @Override
    public int hashCode() {
        int result = getArrivalAirport().hashCode();
        result = 31 * result + getDepartureAirport().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "arrivalAirport='" + arrivalAirport + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                '}';
    }
}
