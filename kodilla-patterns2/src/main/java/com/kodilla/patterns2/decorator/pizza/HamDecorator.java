package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class HamDecorator extends AbstractPizzaOrderDecorator{
    public HamDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public String addComponent() {
        return super.addComponent() + ", ham";
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(Valuation.HAM.getCost());
    }
}
