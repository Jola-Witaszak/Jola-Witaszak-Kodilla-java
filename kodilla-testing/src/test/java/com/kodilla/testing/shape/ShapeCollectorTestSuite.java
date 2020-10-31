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
        public void testAddFigureCircle() {
            //Given
            Shape circle = new Circle( 12.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            List<Shape> figures = new ArrayList<>();

            //When
            shapeCollector.addFigure(circle);
            shapeCollector.getFigure(0);

            //Then
            assertEquals(circle, shapeCollector.getFigure(0));
        }
        @Test
        public void testAddFigureSquare() {
            //Given
            Shape square = new Square(8.0);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(square);
            shapeCollector.getFigure(0);

            //Then
            assertEquals(square, shapeCollector.getFigure(0));

        }

        @Test
        public void testAddFigureTriangle() {
            //Given
            Shape triangle = new Triangle(4.5, 18.0);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(triangle);
            shapeCollector.getFigure(0);

            //Then
            assertEquals(shapeCollector.getFigure(0), triangle);
        }
    }

    @Nested
    @DisplayName("Figures removal tests")
    class TestRemoveFigure {
        @Test
        public void testRemoveFigureCircle() {
            //Given
            Shape circle = new Circle(15.0);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            //When
            boolean result = shapeCollector.removeFigure(circle);

            //Then
            assertTrue(result);
        }

        @Test
        public void testRemoveFigureSquare() {
            //Given
            Shape square = new Square(12.0);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);

            //When
            boolean result = shapeCollector.removeFigure(square);

            //Then
            assertTrue(result);
        }

        @Test
        public void testRemoveFigureTriangle() {
            //Given
            Shape triangle = new Triangle(6.6, 4.2);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(triangle);

            //When
            boolean result = shapeCollector.removeFigure(triangle);

            //Then
            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Returning the names of all figures in the form of one String.")
    class TestShowFigures {
        @Test
        public void testShowFigures() {
            //Given
            Shape square = new Square( 12.0);
            Shape triangle = new Triangle(8.2, 18.0);
            Shape circle = new Circle( 15.0);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);
            shapeCollector.addFigure(circle);

            //When
            shapeCollector.showFigures();
            String expectedResult = square.getShapeName() + ", " + triangle.getShapeName() + ", " + circle.getShapeName();

            //Then
            assertEquals(expectedResult, shapeCollector.showFigures());
        }
    }

    @Nested
    @DisplayName("Figure retrieval tests")
    class TestGetFigure {
        @Test
        public void testGetFigure() {
            //Given
            Shape square = new Square(12.0);
            Shape triangle = new Triangle(8.4, 18.0);
            Shape circle = new Circle(15.0);
            ShapeCollector shapeCollector = new ShapeCollector ();
            shapeCollector.addFigure(circle);
            //When
            Shape result = shapeCollector.getFigure(0);
            //Then
            assertEquals(result, circle);
        }
    }
}