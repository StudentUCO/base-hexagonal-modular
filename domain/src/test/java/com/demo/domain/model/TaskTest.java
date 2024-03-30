package com.demo.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TaskTest {
    @Test
    public void testBuild() {
        Long id = 1L;
        String title = "Test Title";
        String description = "Test Description";
        LocalDateTime creationDate = LocalDateTime.now();
        boolean completed = false;

        Task task = Task.build(id, title, description, creationDate, completed);

        assertNotNull(task);
        assertEquals(id, task.getId());
        assertEquals(title, task.getTitle());
        assertEquals(description, task.getDescription());
        assertEquals(creationDate, task.getCreationDate());
        assertEquals(completed, task.isCompleted());
    }
}