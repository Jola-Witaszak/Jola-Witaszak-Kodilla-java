package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

     static void getAverage(int[] numbers) {
         IntStream.range(0, numbers.length)
                 .forEach(i -> System.out.println(numbers[i]));

         OptionalDouble streamOfArrayNumbers = IntStream.range(0, numbers.length)
            .map(i -> numbers[i])
            .average();

         double average = streamOfArrayNumbers.orElse(-1);
         System.out.println("The average of array elements is: " + average);
    }
}
