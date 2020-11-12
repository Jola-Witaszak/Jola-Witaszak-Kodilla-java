package com.kodilla.stream;

import com.kodilla.stream.array.ArrayOperations;

public class StreamMain {
   public static void main(String[] args) {

       int[] numbers = {9, 21, 15, 8, 1, 66, 2, 7, 14, 71, 45, 6, 38, 49, 88, 80, 112, 33, 40, 21};
       ArrayOperations.printNumbers(numbers);
       System.out.println("The average is: " + ArrayOperations.getAverage(numbers));
    }
}
