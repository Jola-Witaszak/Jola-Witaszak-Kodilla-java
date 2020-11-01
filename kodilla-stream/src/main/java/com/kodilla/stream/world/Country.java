package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {

    private final String countryName;
    private final String population;

    public Country(final String countryName, final String population) {
        this.countryName = countryName;
        this.population = population;
    }

    public BigDecimal getPopulation() {
        return new BigDecimal(this.population);
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", population='" + population + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return getCountryName().equals(country.getCountryName());
    }

}
