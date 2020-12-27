package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class BoardTestSuite {
    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        board.getToDoList().addTask("new to do task");
        board.getInProgressList().addTask("new task in progress");
        board.getDoneList().addTask("new done task");
        //When
        String task1 = board.getToDoList().getTask(0);
        String task2 = board.getInProgressList().getTask(0);
        String task3 = board.getDoneList().getTask(0);
        //Then
        System.out.println(task1 + "\n" + task2 + "\n"+ task3 );
    }
}
