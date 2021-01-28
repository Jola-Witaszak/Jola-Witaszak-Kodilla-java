package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {
    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shopping = taskFactory.createTask(TaskType.SHOPPING, "Buying bread", "bread", 2.0);
        shopping.executeTask();
        //Then
        assertEquals("Buying bread", shopping.getTaskName());
        assertTrue(shopping.isTaskExecuted());
    }
    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task painting = taskFactory.createTask(TaskType.PAINTING,"Christmas decorations", "red", "baubles" );
        painting.executeTask();
        //Then
        assertEquals("Christmas decorations", painting.getTaskName());
        assertTrue(painting.isTaskExecuted());
    }
    @Test
    void testFactoryDriving() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task driving = taskFactory.createTask(TaskType.DRIVING, "Shopping trip",  "shop", "car");
        driving.executeTask();
        //Then
        assertEquals("Shopping trip", driving.getTaskName());
        assertTrue(driving.isTaskExecuted());
    }
}
