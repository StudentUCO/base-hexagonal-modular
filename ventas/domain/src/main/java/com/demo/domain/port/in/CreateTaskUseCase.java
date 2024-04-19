package com.demo.domain.port.in;

import com.demo.domain.model.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
