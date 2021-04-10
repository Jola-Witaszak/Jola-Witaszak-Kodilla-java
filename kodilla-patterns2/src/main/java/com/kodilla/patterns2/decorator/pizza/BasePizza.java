package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasePizza implements PizzaOrder{
    @Override
    public String addComponent() {
        return "Pizza bottom, tomato sauce, cheese";
    }

    @Override
    public BigDecimal getPrice() {
        return Valuation.BASE_PIZZA.getCost();
    }
}
