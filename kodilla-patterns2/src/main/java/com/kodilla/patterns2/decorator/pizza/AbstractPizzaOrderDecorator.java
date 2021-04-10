package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AbstractPizzaOrderDecorator implements PizzaOrder{
    private final PizzaOrder pizzaOrder;

    public AbstractPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public String addComponent() {
        return pizzaOrder.addComponent();
    }

    @Override
    public BigDecimal getPrice() {
        return pizzaOrder.getPrice();
    }
}
