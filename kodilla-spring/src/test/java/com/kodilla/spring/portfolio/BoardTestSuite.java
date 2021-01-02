package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAddonToDoList() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        board.getToDoList().addTask("new to do task");

        //When
        String task1 = board.getToDoList().getTask(0);

        //Then
        assertEquals("new to do task", task1);
    }

    @Test
    void testTaskAddOnInProgressList() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        board.getInProgressList().addTask("new task in progress");

        //When
        String task2 = board.getInProgressList().getTask(0);

        //Then
        assertEquals("new task in progress", task2);
    }

    @Test
    void testTaskAddOnDoneList() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        board.getDoneList().addTask("new done task");

        //When
        String task3 = board.getDoneList().getTask(0);

        //Then
        assertEquals("new done task", task3);
    }
}
