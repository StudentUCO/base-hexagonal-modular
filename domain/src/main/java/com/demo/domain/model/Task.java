package com.demo.domain.model;

import java.time.LocalDateTime;

public class Task {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime creationDate;
    private final boolean completed;

    private Task(Long id, String title, String description, LocalDateTime creationDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.completed = completed;
    }

    public static Task build(Long id, String title, String description, LocalDateTime creationDate, boolean completed) {
        return new Task(id, title, description, creationDate, completed);
    }

    public static Task rebuild(Long id, String title, String description, LocalDateTime creationDate, boolean completed) {
        return new Task(id, title, description, creationDate, completed);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public boolean isCompleted() {
        return completed;
    }
}
