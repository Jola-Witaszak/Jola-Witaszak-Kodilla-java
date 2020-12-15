package com.kodilla.task_13_2;

public class BankTransfer implements PaymentService {
    @Override
    public void createPayment(Customer customer, Supplier supplier) {
        System.out.println("Payment made from the customer: " + customer + " to the supplier: " + supplier);
    }
}
