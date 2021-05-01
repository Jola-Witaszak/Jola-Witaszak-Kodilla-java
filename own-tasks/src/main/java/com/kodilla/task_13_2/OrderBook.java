package com.kodilla.task_13_2;

public class OrderBook implements OrderRepository {
    @Override
    public void addOrder(Customer customer, Item item, Supplier supplier) {
        System.out.println("A completed order was added to the repository. Customer: "+ customer + " supplier: " + supplier + " item: " + item);
    }
}
