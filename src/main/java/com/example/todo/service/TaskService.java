package com.example.todo.service;

import com.example.todo.dto.TaskDto;
import com.example.todo.entity.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<TaskDto> getAllTasks(){
        return taskRepository.findAll().stream().map(this::toDto).toList();
    }

    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID not found"));
        return toDto(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

   /* public TaskDtoResponse createTask() {

    }*/

    private TaskDto toDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setCompleted(task.isCompleted());
        dto.setCreatedAt(task.getCreatedAt());
        return dto;
    }

    public TaskDto createTask(TaskDtoRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        Task saved = taskRepository.save(task);
        return toDto(saved);
    }
}
