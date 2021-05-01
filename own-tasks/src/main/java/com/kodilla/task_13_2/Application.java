package com.kodilla.task_13_2;

public class Application {
    public static void main(String[] args) {
        DataProvided dataProvided = new DataProvided();
        DataRequired dataRequired = dataProvided.provideOrderDetails();

        ProductOrderService productOrderService = new ProductOrderService(new MailService(), new OrderBook(),
                new BankTransfer(), new SaleByCompanies());
        productOrderService.process(dataRequired);
    }
}
