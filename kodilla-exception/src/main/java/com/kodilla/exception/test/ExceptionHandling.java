package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
            try {
                System.out.println(secondChallenge.probablyIWillThrowException(1.5, 5.5));
            } catch (Exception e) {
                System.out.println("Numbers are outside the expected range. Enter x between 1 and 1.99 and y not 1.5");
            } finally {
                System.out.println("Please, somebody tell me what this method does");
            }
    }
}
