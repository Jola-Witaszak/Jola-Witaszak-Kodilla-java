package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    final private List<Shape> figures = new ArrayList<>();

    public void addFigure(Shape shape) {
        figures.add(shape);
    }

    public boolean removeFigure (Shape shape) {
        boolean deleteResult = false;
        if (figures.contains(shape)) {
            figures.remove(shape);
            deleteResult = true;
        }
        return deleteResult;
    }

    public Shape getFigure (int n) {
        Shape figure = null;
        if (n >= 0 && n < figures.size()) {
        figure = figures.get(n);
        }
        return figure;
    }

    public String showFigures() {
        String allFigures = null;
        String figuresAsOneString = "";
        for (int i = 0; i < figures.size(); i++) {
            allFigures = figures.get(i).getShapeName();
            if (i < figures.size() -1) {
                allFigures = figures.get(i).getShapeName() + ", ";
            }
            figuresAsOneString += allFigures;
        }
        return figuresAsOneString;
    }
}
