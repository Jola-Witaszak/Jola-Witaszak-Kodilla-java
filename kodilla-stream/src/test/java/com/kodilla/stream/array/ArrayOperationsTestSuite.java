package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {
    @Test
    void testGetAverage() {
        //Given
        int[] arrayOfNumbers = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};

        //When
        ArrayOperations.getAverage(arrayOfNumbers);

        //Then
        OptionalDouble averageOfArrayNumbers = IntStream.range(0, arrayOfNumbers.length)
                .map(i -> arrayOfNumbers[i])
                .average();

        double result = averageOfArrayNumbers.orElse(-1);

        assertEquals(2.0, result, 0.001);
    }
}
