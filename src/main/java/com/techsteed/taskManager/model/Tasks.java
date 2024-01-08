package com.techsteed.taskManager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDateTime updatedOn;

    private LocalDate dueDate;

    private Integer progress;

    // Constructors, Getters and Setters
//    @OneToOne
//    private Integer userId;
    // Enum for TaskStatus
    public enum TaskStatus {
        COMPLETED,
        PENDING
    }

}
