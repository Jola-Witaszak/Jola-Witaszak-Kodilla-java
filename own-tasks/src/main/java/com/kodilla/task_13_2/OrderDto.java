package com.kodilla.task_13_2;

public class OrderDto {
    public Sale sale;
    public boolean isOrdered;

    public OrderDto(Sale sale, boolean isOrdered) {
        this.sale = sale;
        this.isOrdered = isOrdered;
    }

    public Sale getSale() {
        return sale;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
