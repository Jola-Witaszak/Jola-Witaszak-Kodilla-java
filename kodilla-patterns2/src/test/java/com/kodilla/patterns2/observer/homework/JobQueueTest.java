package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobQueueTest {

    @Test
    void testAddTask() {
        //Given
        Student adam = new Student("Adam");
        Student marcus = new Student("Marcus");
        Student marlon = new Student("Marlon");
        Student david = new Student("David");
        Student andrea = new Student("Andrea");
        Mentor devOps = new Mentor("Steven");
        Mentor fullStack = new Mentor("Richard");
        JobQueue javaAdam = new JobQueue("Java", adam);
        JobQueue javaMarcus = new JobQueue("Java", marcus);
        JobQueue pythonMarlon = new JobQueue("Python", marlon);
        JobQueue pythonDavid = new JobQueue("Python", david);
        JobQueue pythonAndrea = new JobQueue("Python", andrea);
        javaAdam.addReceiver(devOps);
        javaMarcus.addReceiver(devOps);
        pythonMarlon.addReceiver(fullStack);
        pythonDavid.addReceiver(fullStack);
        pythonAndrea.addReceiver(fullStack);
        //When
        javaAdam.addTask("http://task1.com");
        javaAdam.addTask("http://task2.com");
        javaAdam.addTask("http://task3.com");
        javaMarcus.addTask("http://task1.com");

        pythonMarlon.addTask("http://task3.com");
        pythonDavid.addTask("http://task4.com");
        pythonAndrea.addTask("http://task5.com");
        //Then
        assertEquals(4, devOps.getUpdateCount());
        assertEquals(3, fullStack.getUpdateCount());
    }
}