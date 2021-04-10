package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TaskListDao2 extends CrudRepository<TaskList2, Integer> {
    List<TaskList2> findByListName(String listName);
    List<TaskList2> countTaskListById(int id);
}
