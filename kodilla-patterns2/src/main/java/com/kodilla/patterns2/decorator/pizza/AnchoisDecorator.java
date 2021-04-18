package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AnchoisDecorator extends AbstractPizzaOrderDecorator{
    public AnchoisDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public String addComponent() {
        return super.addComponent() + ", anchois";
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(Valuation.ANCHOIS.getCost());
    }
}
