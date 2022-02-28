package com.aditya.repository;

import com.aditya.task_entities.TaskValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskValue,Long> {

}
