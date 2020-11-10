package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0){
            throw new ArithmeticException();
        }
        return a / b;
    }


    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            System.out.println(firstChallenge.divide(3, 2));
        } catch (ArithmeticException e) {
            System.out.println("Cannot be divided by zero: " + e);
        } finally {
            System.out.println("Good thing there are computers in this world...");
        }
    }
}
