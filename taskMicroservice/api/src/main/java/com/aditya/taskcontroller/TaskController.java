package com.aditya.taskcontroller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aditya.task_entities.TaskValue;
import com.aditya.taskservice.TaskService;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskValue> saveTask(@RequestBody TaskValue taskValue){

        return new ResponseEntity<TaskValue>(taskService.saveTask(taskValue), HttpStatus.CREATED);
    }

    @GetMapping
    public List<TaskValue> getAllTask(){
        return taskService.getAllTask();
    }




    @PutMapping("{id}")
    public ResponseEntity<TaskValue> updateUser(@PathVariable("id") long id, @RequestBody TaskValue taskValue){
        return new ResponseEntity<TaskValue>(taskService.updateTask(taskValue, id), HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") long id){

        taskService.deleteTask(id);
        return new ResponseEntity<String>("task deleted", HttpStatus.OK);

    }
}
