package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    Calculator calculator;

    @Test
    void testCalculations() {
        //Given
        //When
        calculator.addAToB(4,2);
        calculator.subtractBFromA(4,2);
        calculator.multiplyAByB(4,2);
        calculator.dividesAByB(4,4);
        //Then
    }
}
