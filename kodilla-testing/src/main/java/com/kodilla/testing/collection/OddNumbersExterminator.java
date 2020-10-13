package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {
    List<Integer> evenNumbers = new ArrayList<>();

    public List<Integer> exterminate(List<Integer> numbers) {
        for(Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        return evenNumbers;
    }

    public void printEvenNumbers(List<Integer> numbers) {
        for (Integer number : evenNumbers) {
            System.out.println(number);
        }
    }
}
