package com.aditya.taskservice;

import com.aditya.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.aditya.repository.TaskRepository;
import com.aditya.task_entities.TaskValue;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskValue saveTask(TaskValue taskValue) {
        return taskRepository.save(taskValue);
    }

    @Override
    public List<TaskValue> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public TaskValue updateTask(TaskValue taskValue, long id) {
        TaskValue existingUser=taskRepository.findById(taskValue.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("TaskValue","Id",id));
        existingUser.setDescription(taskValue.getDescription());
        existingUser.setWork(taskValue.getWork());

        taskRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteTask(long id) {
        taskRepository.findById(id).orElse(null);
        taskRepository.deleteById(id);

    }
}
