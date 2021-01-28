package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {
    @Test
    void testBigmacBuild() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("bun with sesame")
                .sauce("garlic sauce")
                .burger("3")
                .sauce("mustard")
                .ingredients("cheese")
                .ingredients("cucumber")
                .ingredients("onion")
                .ingredients("lettuce")
                .build();
        //When
        String amountOfBurgers = bigmac.getBurgers();
        int amountOfIngredients = bigmac.getIngredients().size();
        //Then
        assertEquals("3", amountOfBurgers);
        assertEquals(4, amountOfIngredients);
    }
}
