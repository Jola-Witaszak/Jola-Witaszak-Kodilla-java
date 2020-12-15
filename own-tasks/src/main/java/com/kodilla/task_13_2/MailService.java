package com.kodilla.task_13_2;

public class MailService implements InformationService {
    @Override
    public void sentMessageToCustomer(Customer customer) {
        System.out.println("Sent message to " + customer);
    }

    @Override
    public void sentMessageToSupplier(Supplier supplier) {
        System.out.println("Sent message to " + supplier);
    }
}
