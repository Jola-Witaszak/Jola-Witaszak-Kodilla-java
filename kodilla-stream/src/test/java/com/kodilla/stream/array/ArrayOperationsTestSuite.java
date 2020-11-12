package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {
    @Test
    void testGetAverage() {
        //Given
        int[] numbers = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};

        //When
        ArrayOperations.getAverage(numbers);

        //Then
        double result = IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                .average()
                .orElse(0);

        assertEquals(2.0, result, 0.001);
    }
}
