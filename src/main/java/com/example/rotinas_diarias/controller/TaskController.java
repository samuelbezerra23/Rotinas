package com.example.rotinas_diarias.controller;

import com.example.rotinas_diarias.model.TaskModel;
import com.example.rotinas_diarias.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskModel> createTask(@RequestBody TaskModel taskModel) {
        TaskModel createdTask = taskService.createTask(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        List<TaskModel> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskModel> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
            .map(task -> ResponseEntity.ok(task))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> updateTask(@PathVariable Long id, @RequestBody TaskModel updatedTask) {
        TaskModel task = taskService.updateTask(id, updatedTask);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
