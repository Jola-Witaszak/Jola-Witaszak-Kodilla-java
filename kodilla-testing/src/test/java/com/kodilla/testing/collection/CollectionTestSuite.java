package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin ");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("When create en empty list, then evenNumbers.size() return 0."
    )

    @Test
    void testOddNumbersExterminatorEmptyList () {
        //Given
        OddNumbersExterminator oddExterminator = new OddNumbersExterminator();
        List<Integer> numbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        //When
        int result = evenNumbers.size();
        int expectedResult = 0;
        //Then
        Assertions.assertEquals(0, result);
    }

    @DisplayName("When create list with values, then oddExterminator.exterminate(numbers) return even numbers"
    )

    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddExterminator = new OddNumbersExterminator();
        List<Integer> numbers = new ArrayList<>();
        numbers.add(58);
        numbers.add(72);
        numbers.add(13);
        numbers.add(27);

        List<Integer> evenNumbers = new ArrayList<>();
        evenNumbers.add(58);
        evenNumbers.add(72);

        //When
        List<Integer> result = oddExterminator.exterminate(numbers);
        List<Integer> expectedResult = evenNumbers;

        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}
