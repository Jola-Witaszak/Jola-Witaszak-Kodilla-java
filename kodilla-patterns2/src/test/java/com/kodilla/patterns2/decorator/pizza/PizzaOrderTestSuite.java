package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaOrderTestSuite {
    @Test
    void testPizzaWithAllComponents() {
        //Given
        PizzaOrder pizzaOrder = new BasePizza();
        pizzaOrder = new AdditionalCheeseDecorator(pizzaOrder);
        pizzaOrder = new AnchoisDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        //When
        String orderedPizza = pizzaOrder.addComponent();
        //Then
        assertEquals("Pizza bottom, tomato sauce, cheese, additional cheese, anchois, ham, olives, onion",
                orderedPizza);
    }

    @Test
    void testPizzaWithAllComponentGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasePizza();
        pizzaOrder = new AdditionalCheeseDecorator(pizzaOrder);
        pizzaOrder = new AnchoisDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        //When
        BigDecimal cost = pizzaOrder.getPrice();
        //Then
        assertEquals(new BigDecimal("42.00"), cost);
    }

    @Test
    void testBasePizzaDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasePizza();
        //When
        String description = pizzaOrder.addComponent();
        //Then
        assertEquals("Pizza bottom, tomato sauce, cheese", description);
    }

    @Test
    void testBasePizzaGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasePizza();
        //When
        BigDecimal cost = pizzaOrder.getPrice();
        //Then
        assertEquals(new BigDecimal("16.00"), cost);
    }

    @Test
    void testAddComponentsBasePizzaOnionOlivesAndAnchois() {
        //Given
        PizzaOrder pizzaOrder = new BasePizza();
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new AnchoisDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.addComponent();
        //Then
        assertEquals("Pizza bottom, tomato sauce, cheese, onion, olives, anchois", description);
    }

    @Test
    void testGetCostBasePizzaWithOnionOlivesAndAnchois() {
        //Given
        PizzaOrder pizzaOrder = new BasePizza();
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new AnchoisDecorator(pizzaOrder);
        //When
        BigDecimal cost = pizzaOrder.getPrice();
        //Then
        assertEquals(new BigDecimal("30.00"), cost);
    }
}