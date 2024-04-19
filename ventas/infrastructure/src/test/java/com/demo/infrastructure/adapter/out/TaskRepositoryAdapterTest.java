package com.demo.infrastructure.adapter.out;

import com.demo.domain.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@ActiveProfiles("test")
class TaskRepositoryAdapterTest {
    private final TaskRepositoryAdapter taskRepositoryAdapter;

    @Autowired
    TaskRepositoryAdapterTest(TaskRepositoryAdapter taskRepositoryAdapter) {
        this.taskRepositoryAdapter = taskRepositoryAdapter;
    }

    @Test
    public void testSave() {
        String title = "Test Title";
        String description = "Test Description";
        LocalDateTime creationDate = LocalDateTime.now();
        boolean completed = false;

        Task task = Task.build(null, title, description, creationDate, completed);

        Task result = taskRepositoryAdapter.save(task);

        assertNotNull(result);
    }
}