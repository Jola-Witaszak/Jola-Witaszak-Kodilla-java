package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public interface PizzaOrder {
    String addComponent();
    BigDecimal getPrice();
}
