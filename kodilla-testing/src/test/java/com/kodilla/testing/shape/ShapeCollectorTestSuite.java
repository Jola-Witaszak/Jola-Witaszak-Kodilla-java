package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ShapeCollector Test Suite")
public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter); }

    @Nested
    @DisplayName("Figures addition tests")
    class TestAdditionFigures {
        @Test
        void testAddFigureCircle() {
            //Given
            List<Shape> figures = new ArrayList<>();
            Shape circle = new Circle("circle", 150);
            ShapeCollector shapeCollector = new ShapeCollector(circle);
            shapeCollector.addFigure(circle);
            //When
            figures.add(circle);
            boolean isEmpty = figures.isEmpty();
            //Then
            assertFalse(isEmpty);
            assertEquals(1, figures.size());
        }

        @Test
        void testAddFigureSquare() {
            //Given
            List<Shape> figures = new ArrayList<>();
            Shape square = new Square("square", 120);
            ShapeCollector shapeCollector = new ShapeCollector(square);
            shapeCollector.addFigure(square);
            //When
            figures.add(square);
            boolean isEmpty = figures.isEmpty();
            //Then
            Assertions.assertFalse(isEmpty);
            Assertions.assertEquals(1, figures.size());
        }

        @Test
        void testAddFigureTriangle() {
            //Given
            List<Shape> figures = new ArrayList<>();
            Shape triangle = new Triangle("triangle", 180);
            ShapeCollector shapeCollector = new ShapeCollector(triangle);
            shapeCollector.addFigure(triangle);
            //When
            figures.add(triangle);
            boolean isEmpty = figures.isEmpty();
            //Then
            Assertions.assertFalse(isEmpty);
            Assertions.assertEquals(1, figures.size());
        }
    }

    @Nested
    @DisplayName("Figures removal tests")
    class TestRemoveFigure {
        @Test
        void testRemoveFigureCircle() {
            //Given
            Shape square = new Circle("square", 120);
            Shape triangle = new Triangle("triangle", 180);
            Shape circle = new Circle("circle", 150);

            List<Shape> figures = new ArrayList<>();
            figures.add(circle);
            figures.add(square);
            figures.add(triangle);

            ShapeCollector shapeCollector = new ShapeCollector(circle);
            shapeCollector.addFigure(circle);
            //When
            shapeCollector.removeFigure(circle);
            boolean result = figures.remove(circle);
            //Then
            Assertions.assertTrue(result);
        }

        @Test
        void testRemoveFigureSquare() {
            //Given
            Shape square = new Circle("square", 120);
            Shape triangle = new Triangle("triangle", 180);
            Shape circle = new Circle("circle", 150);

            List<Shape> figures = new ArrayList<>();
            figures.add(circle);
            figures.add(square);
            figures.add(triangle);

            ShapeCollector shapeCollector = new ShapeCollector(square);
            shapeCollector.addFigure(square);

            //When
            shapeCollector.removeFigure(square);
            boolean result = figures.remove(square);
            //Then
            Assertions.assertTrue(result);
        }

        @Test
        void testRemoveFigureTriangle() {
            //Given
            Shape square = new Circle("square", 120);
            Shape triangle = new Triangle("triangle", 180);
            Shape circle = new Circle("circle", 150);

            List<Shape> figures = new ArrayList<>();
            figures.add(circle);
            figures.add(square);
            figures.add(triangle);

            ShapeCollector shapeCollector = new ShapeCollector(triangle);
            shapeCollector.addFigure(triangle);
            //When
            shapeCollector.removeFigure(triangle);
            boolean result = figures.remove(triangle);
            //Then
            Assertions.assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Returning the names of all figures in the form of one String.")
    class TestShowFigures {
        @Test
        void testShowFigures() {
            //Given
            Shape square = new Circle("square", 120);
            Shape triangle = new Triangle("triangle", 180);
            Shape circle = new Circle("circle", 150);

            List<Shape> figures = new ArrayList<>();
            figures.add(circle);
            figures.add(square);
            figures.add(triangle);

            Shape shape = null;
            ShapeCollector shapeCollector = new ShapeCollector(shape);
            //When
            shapeCollector.showFigures();
            String expectedResult = "circle, square, triangle";
            //Then
            Assertions.assertEquals(expectedResult, shapeCollector.showFigures());
        }
    }

    @Nested
    @DisplayName("Figure retrieval tests")
    class TestGetFigure {
        @Test
        void testGetFigure() {
            //Given
            Shape square = new Circle("square", 120);
            Shape triangle = new Triangle("triangle", 180);
            Shape circle = new Circle("circle", 150);

            List<Shape> figures = new ArrayList<>();
            figures.add(circle);
            figures.add(square);
            figures.add(triangle);

            Shape shape = null;
            ShapeCollector shapeCollector = new ShapeCollector (shape);
            //When
            Shape result = shapeCollector.getFigure(1);
            Shape expectedResult = figures.get(1);
            //Then
            Assertions.assertEquals(expectedResult, result);
        }
    }
}