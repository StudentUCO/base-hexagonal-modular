package com.demo.infrastructure.repository;

import com.demo.domain.model.Task;
import com.demo.infrastructure.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
class JpaTaskRepositoryAdapterTest {

    @Autowired
    private TaskRepositoryAdapter taskRepositoryAdapter;

    @Test
    public void testSave() {
        Long id = null;
        String title = "Test Title";
        String description = "Test Description";
        LocalDateTime creationDate = LocalDateTime.now();
        boolean completed = false;

        Task task = Task.build(id, title, description, creationDate, completed);

        Task result = taskRepositoryAdapter.save(task);

        assertNotNull(result);
    }
}