package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private Shape shape;
    private List<Shape> figures = new ArrayList<>();

    public ShapeCollector(Shape shape) {
        this.shape = shape;
    }

    public void addFigure(Shape shape) {

    }

    public boolean removeFigure (Shape shape) {
        return true;
    }

    public Shape getFigure (int n) {
        return null;
    }

    public Shape showFigures () {
        return null;
    }

}
