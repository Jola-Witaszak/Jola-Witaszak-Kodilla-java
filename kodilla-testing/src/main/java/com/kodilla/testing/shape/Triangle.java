package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private String name;
    private int field;

    public Triangle(String name, int field) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        return name.equals(triangle.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
