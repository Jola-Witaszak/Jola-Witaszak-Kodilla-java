package com.kodilla.task_13_2;

public class ProductOrderService {
    private final InformationService informationService;
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final Sale sale;

    public ProductOrderService(final InformationService informationService, final OrderRepository orderRepository,
                               final PaymentService paymentService, final Sale sale) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
        this.sale = sale;
    }

    public OrderDto process(DataRequired dataRequired) {
        boolean isOrdered = sale.createOrder(dataRequired.getSupplier(), dataRequired.getCustomer(), dataRequired.getItem());

        if (isOrdered) {
            informationService.sentMessageToCustomer(dataRequired.getCustomer());
            informationService.sentMessageToSupplier(dataRequired.getSupplier());
            orderRepository.addOrder(dataRequired.getCustomer(), dataRequired.getItem(), dataRequired.getSupplier());
            paymentService.createPayment(dataRequired.getCustomer(), dataRequired.getSupplier());
            return new OrderDto(sale, true);
        } else {
            return new OrderDto(sale, false);
        }
    }
}
