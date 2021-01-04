package com.kodilla.task_13_2;

public interface OrderRepository {
    void addOrder(Customer customer, Item item, Supplier supplier);
}
