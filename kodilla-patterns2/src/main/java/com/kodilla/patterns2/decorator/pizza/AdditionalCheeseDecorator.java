package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AdditionalCheeseDecorator extends AbstractPizzaOrderDecorator{
    public AdditionalCheeseDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public String addComponent() {
        return super.addComponent() + ", additional cheese";
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(Valuation.ADDITIONAL_CHEESE.getCost());
    }
}
