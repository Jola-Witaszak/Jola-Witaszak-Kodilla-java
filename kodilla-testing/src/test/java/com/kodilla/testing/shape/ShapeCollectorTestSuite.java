package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

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

            //When
            shapeCollector.addFigure(circle);

            //Then
            assertNull(circle);
            assertTrue(shapeCollector.showFigures().contains(circle.toString()));
        }
        @Test
        public void testAddFigureSquare() {
            //Given
            Shape square = new Square(8.0);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(square);

            //Then
            assertNull(square);
            assertTrue(shapeCollector.showFigures().contains(square.toString()));

        }

        @Test
        public void testAddFigureTriangle() {
            //Given
            Shape triangle = new Triangle(4.5, 18.0);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(triangle);

            //Then
            assertNull(triangle);
            assertTrue(shapeCollector.showFigures().contains(triangle.toString()));
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
            shapeCollector.removeFigure(circle);

            //Then
            assertNull(circle);
            assertFalse(shapeCollector.showFigures().contains(circle.toString()));
        }

        @Test
        public void testRemoveFigureSquare() {
            //Given
            Shape square = new Square(12.0);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);

            //When
            shapeCollector.removeFigure(square);

            //Then
            assertNull(square);
            assertFalse(shapeCollector.showFigures().contains(square.toString()));
        }

        @Test
        public void testRemoveFigureTriangle() {
            //Given
            Shape triangle = new Triangle(6.6, 4.2);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(triangle);

            //When
            assertNull(triangle);
            shapeCollector.removeFigure(triangle);

            //Then
            assertFalse(shapeCollector.showFigures().contains(triangle.toString()));
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

            //When
            shapeCollector.showFigures();
            String expectedResult = square + "," + triangle + "," + circle;

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

            //When
            shapeCollector.addFigure(circle);
            Shape result = shapeCollector.getFigure(0);

            //Then
            assertEquals(result, circle);
        }
    }
}