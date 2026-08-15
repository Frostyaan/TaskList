package com.example.todo.controller;


import com.example.todo.dto.TaskDto;
import com.example.todo.entity.Task;
import com.example.todo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDto> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskDto getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }


    @PostMapping
    public Task createTask(@Valid @RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PostMapping
    public TaskDto createTask(@Valid @RequestBody TaskDtoRequest request) {
        return taskService.createTask(request);
    }
}
