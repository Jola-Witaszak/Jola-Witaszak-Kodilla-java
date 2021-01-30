package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.Task_List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class Task_ListDaoTestSuite {
    @Autowired
    private Task_ListDao task_listDao;
    @Test
    void testTaskListDaoSaveWithTask() {
        //Given
        Task task1 = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails taskFinancialDetails1 = new TaskFinancialDetails(new BigDecimal(120), false);
        TaskFinancialDetails taskFinancialDetails2 = new TaskFinancialDetails(new BigDecimal(250), false);
        task1.setTaskFinancialDetails(taskFinancialDetails1);
        task2.setTaskFinancialDetails(taskFinancialDetails2);
        Task_List taskList = new Task_List("ToDoList", "ToDo tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        task1.setTask_list(taskList);
        task2.setTask_list(taskList);
        //When
        task_listDao.save(taskList);
        int id = taskList.getId();
        //Then
        assertNotEquals(0, id);
        //CleanUp
        task_listDao.deleteById(id);
    }
}
