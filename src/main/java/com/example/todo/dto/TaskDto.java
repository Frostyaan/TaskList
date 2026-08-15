package com.example.todo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class TaskDto {
    private Long id;

    private String description;

    private String title;

    private boolean completed;

    private Instant createdAt;
}
