package com.aditya.taskservice;

import com.aditya.task_entities.TaskValue;

import java.util.List;

public interface TaskService {

    TaskValue saveTask(TaskValue taskValue);
    List<TaskValue> getAllTask();
    TaskValue updateTask(TaskValue taskValue, long id);
    void deleteTask(long id);
}
