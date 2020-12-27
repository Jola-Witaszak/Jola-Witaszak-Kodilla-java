package com.kodilla.task_13_2;

public class DataRequired {
    private final Customer customer;
    private final Item item;
    private final Supplier supplier;

    public DataRequired(Customer customer, Item item, Supplier supplier) {
        this.customer = customer;
        this.item = item;
        this.supplier = supplier;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Item getItem() {
        return item;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}
