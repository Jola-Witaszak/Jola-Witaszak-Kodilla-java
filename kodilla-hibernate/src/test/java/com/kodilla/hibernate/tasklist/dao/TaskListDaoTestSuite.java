package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    TaskListDao taskListDao;

    private static final String DESCRIPTION = "car repair";
    private static final String NAME = "ToDo List";

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(NAME, DESCRIPTION);
        taskListDao.save(taskList);
        int id = taskList.getId();
        //When
        List<TaskList> result =  taskListDao.findByListName(NAME);
        //Then
        assertEquals(1, result.size());
        //CleanUp
        taskListDao.deleteById(id);
    }
}
