package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskDaoTestSuite {
    @Autowired // bez adnotacji jest nullPointerException, pole jest zadeklarowane, a nie utworzony nigdzie obiekt. Z autowired spring tworzy beana
    private TaskDao taskDao;

    @Autowired
    private Task_ListDao task_listDao;

    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    void
    testTaskDaoSave() {
        //Given
        Task task = new Task(DESCRIPTION, 7);
        //When
        taskDao.save(task);
        //Then
        int id = task.getId();
        Optional<Task> readTask = taskDao.findById(id);
        assertTrue(readTask.isPresent());
        //CleanUp
        taskDao.deleteById(id);
    }

    @Test
    void testTaskDaoFindByDuration() {
        //Given
        Task task = new Task(DESCRIPTION, 8);
        taskDao.save(task);
        int duration = task.getDuration();
        //When
        List<Task> readTask = taskDao.findByDuration(duration);
        //Then
        assertEquals(1, readTask.size());
        //CleanUp
        int id = readTask.get(0).getId();
        taskDao.deleteById(id);
    }

    @Test
    void testTaskDaoSaveWithFinancialDetails() {
        //Given
        Task task = new Task(DESCRIPTION, 9);
        task.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal(150), false));
        //When
        taskDao.save(task);
        int id = task.getId();
        //Then
        assertNotEquals(0, id);
        //CleanUp
        taskDao.deleteById(id);
    }
}
