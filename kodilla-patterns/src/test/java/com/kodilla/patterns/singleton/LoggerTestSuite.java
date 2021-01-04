package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {
    @Test
    void shouldReturnTheLastLogWritten() {
        //Given
        Logger logger = Logger.INSTANCE;
        logger.log("access password change");
        //When
        String log = logger.getLastLog();
        //Then
        assertEquals("access password change", log);
    }
}
