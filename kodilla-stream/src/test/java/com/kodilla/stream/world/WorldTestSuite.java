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
        Country country1 = new Country("Russia", "142122776");
        Country country2 = new Country("France", "67364357");
        Country country3 = new Country("Spain", "49331076");
        Country country4 = new Country("China", "1401585247");
        Country country5 = new Country("India", "1359527235");
        Country country6 = new Country("Vietnam", "97040334");
        Country country7 = new Country("USA", "329256465");
        Country country8 = new Country("Mexico", "125959205");
        Country country9 = new Country("Ethiopia", "108386391");
        Country country10 = new Country("Nigeria", "203452505");

        Continent europe = new Continent("Europe");
        Set<Country> europeanCountries = new HashSet<>();
        europe.addCountry(country1);
        europe.addCountry(country2);
        europe.addCountry(country3);

        Continent asia = new Continent("Asia");
        Set<Country> asiaCountries = new HashSet<>();
        asia.addCountry(country4);
        asia.addCountry(country5);
        asia.addCountry(country6);

        Continent northAmerica = new Continent("North America");
        Set<Country> northAmericanCountries = new HashSet<>();
        northAmerica.addCountry(country7);
        northAmerica.addCountry(country8);

        Continent africa = new Continent("Africa");
        Set<Country> africanCountries = new HashSet<>();
        africa.addCountry(country9);
        africa.addCountry(country10);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(africa);
        world.addContinent(asia);
        world.addContinent(northAmerica);

        //When
        BigDecimal totalQuantityOfPeople = world.getPeopleQuantity();

        //Then
        BigDecimal expectedQuantityOfPeople = new BigDecimal("3884025591");
        assertEquals(expectedQuantityOfPeople, totalQuantityOfPeople);
    }
}
