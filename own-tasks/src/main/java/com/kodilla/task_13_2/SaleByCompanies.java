package com.kodilla.task_13_2;

public class SaleByCompanies implements Sale {
    @Override
    public boolean createOrder(Supplier supplier, Customer customer, Item item) {
        System.out.println("An order has been created for " + item + " per amount: " + item.getValue() +
                " from the company: " + supplier + " to the customer: " + customer);
        return true;
    }
}
