package com.techsteed.taskManager.service;

import com.techsteed.taskManager.model.Tasks;
import com.techsteed.taskManager.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskDao taskDao;
    public ResponseEntity<List<Tasks>> getAllTasks(){

        try{
            return new ResponseEntity<>(taskDao.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Tasks>> getTasksByStatus(Tasks.TaskStatus status) {
        try{
            return new ResponseEntity<>(taskDao.findByStatus(status), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addTask(Tasks task) {
        try {
            taskDao.save(task);
            return new ResponseEntity<String>(HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deleteTaskById(Long Id) {
        try {
            taskDao.deleteById(Id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<String> updateTask(Tasks task){
        try {
            taskDao.save(task);
            return new ResponseEntity<String>(HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Tasks> getTasksByTitle(String title) {
        try{
            return new ResponseEntity<Tasks>(taskDao.findByTitle(title),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( new Tasks(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Optional<Tasks>> getTasksById(Long id) {
        try{
            return new ResponseEntity<Optional<Tasks>>(taskDao.findById(id),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }
}
