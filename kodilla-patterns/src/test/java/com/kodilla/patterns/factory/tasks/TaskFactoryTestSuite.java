package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {
    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shopping = taskFactory.createTask(TaskFactory.SHOPPING);
        //Then
        assertEquals("Painting articles", shopping.getTaskName());
        assertEquals(1, shopping.executeTask());
        assertTrue(shopping.isTaskExecuted());
    }
    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task painting = taskFactory.createTask(TaskFactory.PAINTING);
        //Then
        assertEquals("Christmas decorations", painting.getTaskName());
        assertTrue(painting.isTaskExecuted());
    }
    @Test
    void testFactoryDriving() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task driving = taskFactory.createTask(TaskFactory.DRIVING);
        //Then
        assertEquals("Shopping trip", driving.getTaskName());
        assertTrue(driving.isTaskExecuted());
    }
}
