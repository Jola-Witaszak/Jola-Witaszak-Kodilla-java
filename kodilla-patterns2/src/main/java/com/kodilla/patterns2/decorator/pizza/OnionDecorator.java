package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class OnionDecorator extends AbstractPizzaOrderDecorator{
    public OnionDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public String addComponent() {
        return super.addComponent() + ", onion";
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(Valuation.ONION.getCost());
    }

}
