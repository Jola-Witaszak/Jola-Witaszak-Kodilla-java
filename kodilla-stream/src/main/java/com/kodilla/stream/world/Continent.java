package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;

public final class Continent {
    private final String continentName;
    private final Set<Country> countriesOnContinent = new HashSet<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public Set<Country> getCountriesOnContinent() {
        return new HashSet<>(countriesOnContinent);
    }

    public void addCountry (Country country) {
        countriesOnContinent.add(country);
    }

    public boolean removeCountry(Country country) {
        return countriesOnContinent.remove(country);
    }

    public String getContinentName() {
        return continentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continent continent = (Continent) o;

        return getContinentName().equals(continent.getContinentName());
    }

    @Override
    public int hashCode() {
        return getContinentName().hashCode();
    }
}
