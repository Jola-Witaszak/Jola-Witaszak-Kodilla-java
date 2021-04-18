package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class OlivesDecorator extends AbstractPizzaOrderDecorator{
    public OlivesDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public String addComponent() {
        return super.addComponent() + ", olives";
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(Valuation.OLIVES.getCost());
    }
}
