package com.kodilla.task_13_2;

public class DataProvided {

    public DataRequired provideOrderDetails() {
        Customer customer = new Customer("Alan", "Wiley", "Opole, ul. Długa 16");
        Item item = new Item("Toy", 260.35, 2 );
        Supplier supplier = new Supplier("Agora", "Piła, ul Wawelska 4");

        return new DataRequired(customer, item, supplier);
    }
}
