package com.demo.infrastructure.dto;

import com.demo.domain.model.Task;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;

    public Task toDomain() {
        return Task.build(id, title, description, creationDate, completed);
    }
}
