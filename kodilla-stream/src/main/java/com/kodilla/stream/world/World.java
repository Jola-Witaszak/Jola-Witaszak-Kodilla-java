package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class World {

    private final Set<Continent> continentsOfTheWorld;

    public World() {
        continentsOfTheWorld = new HashSet<>();
    }

    public void addContinent(Continent continent) {
        continentsOfTheWorld.add(continent);
    }

    public boolean removeContinent(Continent continent) {
        return continentsOfTheWorld.remove(continent);
    }

    public Set<Continent> getContinentsOfTheWorld() {
        return new HashSet<>(continentsOfTheWorld);
    }

    public BigDecimal getPeopleQuantity() {
        return getContinentsOfTheWorld().stream()
                .flatMap(continent -> continent.getCountriesOnContinent().stream())
                .map(Country::getPopulation)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
