package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task_List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface Task_ListDao extends CrudRepository<Task_List, Integer> {
}
