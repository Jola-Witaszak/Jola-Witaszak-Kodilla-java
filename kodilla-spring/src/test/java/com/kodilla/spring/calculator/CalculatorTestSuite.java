package com.kodilla.spring.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    Calculator calculator;

    @DisplayName("Tests to check the correct addition")

    @Test
    void shouldReturnTheCorrectResultOfAddingZeroToZero() {
        //Given
        //When
        double result = calculator.add(0.0,0.0);
        //Then
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfAddingAPositiveNumberAndZero() {
        //Given
        // When
        double result = calculator.add(1.0, 0);
        // Then
        assertEquals(1.0, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfAddingNegativeAndZero() {
        //Given
        // When
        double result = calculator.add(-1.0, 0);
        // Then
        assertEquals(-1.0, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfAddingTwoPositiveNumbers() {
        //Given
        // When
        double result = calculator.add(1.5, 1.1);
        // Then
        assertEquals(2.6, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfAddingTwoNegativeNumbers() {
        //Given
        // When
        double result = calculator.add(-2.2, -2.2);
        // Then
        assertEquals(-4.4, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfAddingPositiveNumberAndNegativeNumber() {
        //Given
        // When
        double result = calculator.add(1.0, -2.0);
        // Then
        assertEquals(-1.0, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfAddingNegativeNumberAndPositive() {
        //Given
        // When
        double result = calculator.add(-3.0, 5.0);
        // Then
        assertEquals(2.0, result);
    }

    @DisplayName("Tests to check the correct subtraction")

    @Test
    void shouldReturnTheCorrectResultOfSubtractingZeroFromZero() {
        //Given
        //When
        double result = calculator.sub(0.0, 0.0);
        //Then
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfSubtractingAPositiveNumberFromZero() {
        //Given
        //When
        double result = calculator.sub(0.0, 1.0);
        //Then
        assertEquals(-1.0, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfSubtractingANegativeNumberFromZero() {
        //Given
        //When
        double result = calculator.sub(0.0, -1.0);
        //Then
        assertEquals(1.0, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfSubtractingZeroFromAPositiveNumber() {
        //Given
        //When
        double result = calculator.sub(2.5, 0.0);
        //Then
        assertEquals(2.5, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfSubtractingZeroFromANegativeNumber() {
        //Given
        //When
        double result = calculator.sub(-1.0, 0.0);
        //Then
        assertEquals(-1.0, result, 0.001);
    }

    @DisplayName("Tests to check the correct multiplication")

    @Test
    void shouldReturnTheCorrectResultOfMultiplyingZeroAndZero() {
        //Given
        //When
        double result = calculator.mul(0.0, 0.0);
        //Then
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfMultiplyingAPositiveNumberByZero() {
        //Given
        //When
        double result = calculator.mul(1.0, 0.0);
        //Then
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfMultiplyingNegativeAndZero() {
        //Given
        //When
        double result = calculator.mul((-1.0), 0.0);
        //Then
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfMultiplyingTwoPositiveNumbers() {
        //Given
        //When
        double result = calculator.mul(2.0, 2.0);
        //Then
        assertEquals(4.0, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfMultiplyingTwoNegativeNumbers() {
        //Given
        //When
        double result = calculator.mul(-2.0, -2.0);
        //Then
        assertEquals(4.0, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfMultiplyingAPositiveNumberAndANegativeNumber() {
        //Given
        //When
        double result = calculator.mul(2.0, -3.2);
        //Then
        assertEquals(-6.4, result, 0.001);
    }

    @Test
    void shouldReturnTheCorrectResultOfMultiplyingANegativeNumberAndAPositiveNumber() {
        //Given
        //When
        double result = calculator.mul(-2.0, 2.0);
        //Then
        assertEquals(-4.0, result, 0.001);
    }

    @DisplayName("Tests to check the correct division")

    @Test
    void shouldThrowExceptionWhenDividingZeroByZero() {
        //Given
        //When & //Then
        assertThrows(Exception.class, () -> calculator.div(0.0, 0.0));
    }

    @Test
    void shouldThrowExceptionWhenDividingAPositiveNumberByZero() {
        //Given
        //When & //Then
        assertThrows(Exception.class, () -> calculator.div(2.6, 0.0));
    }

    @Test
    void shouldThrowExceptionWhenDividingANegativeNumberByZero() {
        //Given
        //When & //Then
        assertThrows(Exception.class, () -> calculator.div((-3.3), 0.0));
    }

    @Test
    void shouldNotThrowExceptionWhenDividingZeroByAPositiveNumber() {
        //Given
        //When & //Then
        assertDoesNotThrow(() -> calculator.div(0.0, 1.025));
    }

    @Test
    void shouldReturnTheCorrectResultOfDividingZeroByAPositiveNumber() {
        //Given
        //When
        double result = calculator.div(0.0, 1.025);
        //Then
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void shouldNotThrowExceptionWhenDividingZeroByANegativeNumber() {
        //Given
        //When & //Then
        assertDoesNotThrow(() -> calculator.div(0.0, -1.025));
    }

    @Test
    void shouldReturnTheCorrectResultOfDividingZeroByANegativeNumber() {
        //Given
        //When
        double result = calculator.div(0.0, -1.025);
        //Then
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void shouldNotThrowExceptionWhenDividingTwoPositiveNumbers() {
        //Given
        //When & //Then
        assertDoesNotThrow(() -> calculator.div(1.025, 1.025));
    }

    @Test
    void shouldReturnTheCorrectResultOfDividingTwoPositiveNumbers() {
        //Given
        //When
        double result = calculator.div(1.025, 1.025);
        //Then
        assertEquals(1.0, result, 0.001);
    }

    @Test
    void shouldNotThrowExceptionWhenDividingTwoNegativeNumbers() {
        //Given
        //When & //Then
        assertDoesNotThrow(() -> calculator.div((-1.025), (-1.025)));
    }

    @Test
    void shouldReturnTheCorrectResultOfDividingTwoNegativeNumbers() {
        //Given
        //When
        double result = calculator.div((-1.025), (-1.025));
        //Then
        assertEquals(1.0, result, 0.001);
    }

    @Test
    void shouldNotThrowExceptionWhenDividingAPositiveNumberByANegativeNumber() {
        //Given
        //When & //Then
        assertDoesNotThrow(() -> calculator.div((2.0), (-2.0)));
    }

    @Test
    void shouldReturnTheCorrectResultOfDividingAPositiveNumberByANegativeNumber() {
        //Given
        //When
        double result = calculator.div(2.0, (-2.0));
        //Then
        assertEquals((-1.0), result, 0.001);
    }

    @Test
    void shouldNotThrowExceptionWhenDividingANegativeNumberByAPositiveNumber() {
        //Given
        //When & //Then
        assertDoesNotThrow(() -> calculator.div((-1.025), (1.025)));
    }

    @Test
    void shouldReturnTheCorrectResultOfDividingANegativeNumberByAPositiveNumber() {
        //Given
        //When
        double result = calculator.div((-1.025), 1.025);
        //Then
        assertEquals((-1.0), result, 0.001);
    }
}
