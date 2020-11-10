package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProbablyIWillThrowExceptionTestSuite {
    @Test
    void itDoesNotThrowExceptionWhenXAndYAreInCorrectRange() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, -4));
    }
    @Test
    void ShouldThrowExceptionWhenXAndYAreOutOfRange() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(-2.5, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0, 1.5))
        );
    }

    @Test
    void ShouldThrowExceptionWhenXIsOutsideValidRangeAndYIsValid_bothBoundaryValues() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.99, 1.51)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 1.49))
        );
    }
    @Test
    void ShouldThrowExceptionWhenYIsOutsideValidRangeAndXIsValid_BoundaryValueX() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.99, 1.5))
        );
    }
}
