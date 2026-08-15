package com.example.todo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "task")
@Getter @Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @NotBlank
    @Column(name = "title")
    private String title;

    @Column(name = "completed")
    private boolean completed;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;
}
