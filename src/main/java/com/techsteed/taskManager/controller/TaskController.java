package com.techsteed.taskManager.controller;

import com.techsteed.taskManager.model.Tasks;
import com.techsteed.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "task")
@CrossOrigin("http://localhost:3000")
public class TaskController {

    @Autowired
    TaskService taskService ;

    @GetMapping(path = "allTasks")
    public ResponseEntity<List<Tasks>> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping(path = "status/{status}")
    public ResponseEntity<List<Tasks>> getTasksByStatus(@PathVariable("status") Tasks.TaskStatus status){
        return taskService.getTasksByStatus(status);
    }

    @GetMapping(path = "id/{id}")
    public ResponseEntity<Optional<Tasks>> getTasksByTitle(@PathVariable("id") Long id){
        return taskService.getTasksById(id);
    }

    @PostMapping(path = "add")
    public ResponseEntity<String> addTask(@RequestBody Tasks task){
        return taskService.addTask(task);

    }

    @DeleteMapping(path = "delete/{Id}")
    public ResponseEntity<String> deleteTasksById(@PathVariable Long Id){
        return taskService.deleteTaskById(Id);
    }

    @PutMapping("update")
    public ResponseEntity<String> updateTask(@RequestBody Tasks task){
        return taskService.updateTask(task);
    }



}
