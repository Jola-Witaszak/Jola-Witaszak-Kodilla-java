package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("FV_01/01/2021");
        Invoice invoiceOne = new Invoice("FV_23/01/2021");

        Product chocolate = new Product("milk chocolate");
        Product bread = new Product("bread graham");
        Product juice = new Product("orange juice");

        Item item1 = new Item(chocolate, invoice, new BigDecimal("8.50"), 2, new BigDecimal("17.0"));
        Item item2 = new Item(bread, invoice, new BigDecimal("4.2"), 1, new BigDecimal("4.2"));
        Item item3 = new Item(juice, invoiceOne, new BigDecimal("8.0"), 3, new BigDecimal("24.0"));

        chocolate.getItems().add(item1);
        bread.getItems().add(item2);
        juice.getItems().add(item3);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoiceOne.getItems().add(item3);
        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        int invoiceIdFromItem1 = item1.getInvoice().getId();

        invoiceDao.save(invoiceOne);
        int invoiceOneId = invoiceOne.getId();

        int productItems = chocolate.getItems().size();
        int invoiceItems = invoice.getItems().size();

        //Then
            assertNotEquals(0, invoiceId);
            assertNotEquals(0, invoiceOneId);
            assertEquals(invoiceId, invoiceIdFromItem1);
            assertEquals(1, productItems);
            assertEquals(2, invoiceItems);
        //CleanUp
        invoiceDao.deleteById(invoiceId);
        invoiceDao.deleteById(invoiceOneId);
    }
}
