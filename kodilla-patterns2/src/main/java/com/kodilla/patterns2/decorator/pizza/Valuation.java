package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public enum Valuation {
    BASE_PIZZA(new BigDecimal("16.00")),
    ADDITIONAL_CHEESE(new BigDecimal("4.00")),
    HAM(new BigDecimal("8.00")),
    OLIVES(new BigDecimal("4.00")),
    ONION(new BigDecimal("2.00")),
    ANCHOIS(new BigDecimal("8.00"));

    private final BigDecimal cost;

    Valuation(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
