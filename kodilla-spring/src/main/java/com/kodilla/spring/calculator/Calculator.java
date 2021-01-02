package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {
    @Autowired
    private Display display;

    public double add(double a, double b) {
        double result = a + b;
        display.displayValue(result);
        return result;
    }

    public double sub(double a, double b) {
        double result = a - b;
        display.displayValue(result);
        return result;
    }

    public double mul(double a, double b) {
        double result = a * b;
        display.displayValue(result);
        return result;
    }

    public double div(double a, double b) throws ArithmeticException {
        if (b == 0) {
            System.out.println("Cannot be divided by ZERO !!!");
            throw new ArithmeticException();
        } else {
            double result = a / b;
            display.displayValue(result);
            return result;
        }
    }
}
