package com.kodilla.stream.zadaniaMoje;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testIntStream {
    @Test
    void intStreamToArray() {
        //Given
        int[] firstFiftyEvenNumbers = IntStream.iterate(0, i -> i + 2)
                .limit(50)
                .toArray();
        //When

        //Then
        assertEquals(50, firstFiftyEvenNumbers.length);
        assertEquals(4, firstFiftyEvenNumbers[2]);
    }

    @Test
    void intStreamToList() {
        //Given
        List<Integer> firstFiftyIntegerNumbers = IntStream.range(0, 50)
                .boxed()
                .collect(Collectors.toList());

        //When

        //Then
        assertEquals(50, firstFiftyIntegerNumbers.size());
        assertEquals(2, firstFiftyIntegerNumbers.get(2));
    }

    @Test
    void testIntStreamToString() {
        //Given
        String firstThreeNumbers = IntStream.of(0, 1, 2)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));

        //When

        //Then
        assertEquals("[0, 1, 2]", firstThreeNumbers);
    }
}
