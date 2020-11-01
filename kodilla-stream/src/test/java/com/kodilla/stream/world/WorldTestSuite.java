package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Country country1 = new Country("Russia", "142122776555");
        Country country2 = new Country("France", "67364357666");
        Country country3 = new Country("Spain", "49331076777");
        Country country4 = new Country("China", "1401585247888");
        Country country5 = new Country("India", "1359527235999");
        Country country6 = new Country("Vietnam", "97_040334555");
        Country country7 = new Country("USA", "329_256465666");
        Country country8 = new Country("Mexico", "125_959205999");
        Country country9 = new Country("Ethiopia", "108_386391777");
        Country country10 = new Country("Nigeria", "203_452505888");

        Continent europe = new Continent("Europe");
        Set<Country> europeanCountries = new HashSet<>();
        europeanCountries.add(country1);
        europeanCountries.add(country2);
        europeanCountries.add(country3);

        Continent asia = new Continent("Asia");
        Set<Country> asiaCountries = new HashSet<>();
        asiaCountries.add(country4);
        asiaCountries.add(country5);
        asiaCountries.add(country6);

        Continent northAmerica = new Continent("North America");
        Set<Country> northAmericanCountries = new HashSet<>();
        northAmericanCountries.add(country7);
        northAmericanCountries.add(country8);

        Continent africa = new Continent("Africa");
        Set<Country> africanCountries = new HashSet<>();
        africanCountries.add(country9);
        africanCountries.add(country10);

        World world = new World();
        Set<Continent> continentsOfTheWorld = new HashSet<>();
        continentsOfTheWorld.add(africa);
        continentsOfTheWorld.add(asia);
        continentsOfTheWorld.add(europe);
        continentsOfTheWorld.add(northAmerica);

        //When
        BigDecimal totalQuantityOfPeople = world.getPeopleQuantity();

        //Then
        BigDecimal expectedQuantityOfPeople = new BigDecimal("3884025598770");
        assertEquals(expectedQuantityOfPeople, totalQuantityOfPeople);
    }
}
