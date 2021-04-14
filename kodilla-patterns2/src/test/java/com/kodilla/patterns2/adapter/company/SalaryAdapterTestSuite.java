package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.oldhrsystem.Workers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalaryAdapterTestSuite {
    @Test
    void testTotalSalary() {
        //Given
        Workers workers = new Workers();
        SalaryAdapter salaryAdapter = new SalaryAdapter();
        //When
        double totalSalary = salaryAdapter.totalSalary(workers.getWorkers(), workers.getSalaries());
        //Then
        System.out.println(totalSalary);
        assertEquals(27750.00, totalSalary, 0);
    }
}
