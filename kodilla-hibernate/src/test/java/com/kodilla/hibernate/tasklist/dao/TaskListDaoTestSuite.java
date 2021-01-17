package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        //Given
        String listName = "for repair";
        String description = "list of cars for repair";
        TaskList taskList = new TaskList(listName, description);
        taskListDao.save(taskList);
        //When
        List<TaskList> downLoadedList = taskListDao.findByListName(listName);
        //Then
        assertEquals(1, downLoadedList.size());
        //CleanUp
        taskListDao.deleteAll();
    }
}
