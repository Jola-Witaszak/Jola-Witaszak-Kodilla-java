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
            Shape circle = new Circle( 12.5);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(circle);

            //Then
            assertEquals(circle, shapeCollector.addFigure(circle));
        }
        @Test
        void testAddFigureSquare() {
            //Given
            Shape square = new Square(8.0);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(square);

            //Then
            assertEquals(square, shapeCollector.addFigure(square));

        }

        @Test
        void testAddFigureTriangle() {
            //Given
            Shape triangle = new Triangle(4.5, 18.0);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(triangle);

            //Then
            Assertions.assertEquals(triangle, shapeCollector.addFigure(triangle));
        }
    }

    @Nested
    @DisplayName("Figures removal tests")
    class TestRemoveFigure {
        @Test
        void testRemoveFigureCircle() {
            //Given
            Shape circle = new Circle(15.0);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            //When
            shapeCollector.removeFigure(circle);

            //Then
            Assertions.assertTrue(shapeCollector.removeFigure(circle));
        }

        @Test
        void testRemoveFigureSquare() {
            //Given
            Shape square = new Square(12.0);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);

            //When
            shapeCollector.removeFigure(square);

            //Then
            Assertions.assertTrue(shapeCollector.removeFigure(square));
        }

        @Test
        void testRemoveFigureTriangle() {
            //Given
            Shape triangle = new Triangle(6.6, 4.2);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(triangle);

            //When
            shapeCollector.removeFigure(triangle);

            //Then
            Assertions.assertTrue(shapeCollector.removeFigure(triangle));
        }
    }

    @Nested
    @DisplayName("Returning the names of all figures in the form of one String.")
    class TestShowFigures {
        @Test
        void testShowFigures() {
            //Given
            Shape square = new Square( 12.0);
            Shape triangle = new Triangle(8.2, 18.0);
            Shape circle = new Circle( 15.0);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.showFigures();
            String expectedResult = "circle, square, triangle";

            //Then
            Assertions.assertEquals(expectedResult, shapeCollector.showFigures());
        }
    }

    @Nested
    @DisplayName("Figure retrieval tests ")
    class TestGetFigure {
        @Test
        void testGetFigure() {
            //Given
            Shape square = new Square(12.0);
            Shape triangle = new Triangle(8.4, 18.0);
            Shape circle = new Circle(15.0);
            ShapeCollector shapeCollector = new ShapeCollector ();

            //When
            shapeCollector.addFigure(circle);
            shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(circle, 0);
        }
    }
}