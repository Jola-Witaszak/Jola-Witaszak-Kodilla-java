package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    @Test
    void testTaskListDaoSaveWithTask() {
        //Given
        Task task1 = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails taskFinancialDetails1 = new TaskFinancialDetails(new BigDecimal(120), false);
        TaskFinancialDetails taskFinancialDetails2 = new TaskFinancialDetails(new BigDecimal(250), false);
        task1.setTaskFinancialDetails(taskFinancialDetails1);
        task2.setTaskFinancialDetails(taskFinancialDetails2);
        TaskList taskList = new TaskList("ToDoList", "ToDo tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        //When
        taskListDao.save(taskList);
        int id = taskList.getId();
        //Then
        assertNotEquals(0, id);
        //CleanUp
        taskListDao.deleteById(id);
    }
}
