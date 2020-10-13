package com.kodilla.testing.shape;

public class Circle implements Shape {
    private String name;
    private int field;

    public Circle(String name, int field) {
        this.name = name;
        this.field = field;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public int getField() {
        return field;
    }
}



