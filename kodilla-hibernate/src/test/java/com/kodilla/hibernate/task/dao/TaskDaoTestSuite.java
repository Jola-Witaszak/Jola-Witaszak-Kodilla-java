package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TaskDaoTestSuite {
    @Autowired // bez adnotacji jest nullPointerException, pole jest zadeklarowane, a nie utworzony nigdzie obiekt. Z autowired spring tworzy beana
    private TaskDao taskDao;
    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    void testTaskDaoSave() {
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
        Task task = new Task(DESCRIPTION, 9);
        taskDao.save(task);
        int duration = task.getDuration();
        int id = task.getId();
        //When
        List<Task> readTasks = taskDao.findByDuration(duration);
        //Then
        assertEquals(1, readTasks.size());
        //CleanUp
        taskDao.deleteById(id);
    }
}
