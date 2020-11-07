package com.kodilla.exception.test;

public class FirstChallenge {
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0){
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */

    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            System.out.println(firstChallenge.divide(3, 0));
        } catch (ArithmeticException e) {
            System.out.println("Cannot be divided by zero: " + e);
        } finally {
            System.out.println("It couldn't work...");
        }
    }
}
