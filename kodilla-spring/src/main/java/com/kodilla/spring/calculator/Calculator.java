package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {
    @Autowired
    private Display display;

    public double addAToB(double a, double b) {
        double result = a + b;
        display.displayValue(result);
        return result;
    }

    public double subtractBFromA(double a, double b) {
        double result = a - b;
        display.displayValue(result);
        return result;
    }

    public double multiplyAByB(double a, double b) {
        double result = a * b;
        display.displayValue(result);
        return result;
    }

    public double dividesAByB(double a, double b) {
        double result = a / b;
        display.displayValue(result);
        return result;
    }
}
