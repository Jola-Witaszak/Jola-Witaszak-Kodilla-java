package com.kodilla.stream.invoice.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleInvoiceTestSuite {

    @Test
    void testGetValueToPay() {
        //Given
        SimpleInvoice simpleInvoice = new SimpleInvoice();

        //When
        simpleInvoice.addItem(new SimpleItem(new SimpleProduct("Product1", 17.28), 2.0));
        simpleInvoice.addItem(new SimpleItem(new SimpleProduct("Product2", 11.99), 3.5));
        simpleInvoice.addItem(new SimpleItem(new SimpleProduct("Product3", 6.49), 5.0));

        //Then
        assertEquals(108.975, simpleInvoice.getValueToPay(), 0.001);
    }
}
