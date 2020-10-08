package com.kodilla.testing;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int additionResult = calculator.add(5,5);
        int subtractResult = calculator.subtract(30, 10);
            if (additionResult == 10 && subtractResult == 20) {
                System.out.println("Calculator test is OK!");
            } else {
                System.out.println("Oops ... something went wrong :)");
            }
    }
}
