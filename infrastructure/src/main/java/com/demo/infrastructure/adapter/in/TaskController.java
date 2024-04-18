package com.demo.infrastructure.adapter.in;

import com.demo.application.dto.TaskDTO;
import com.demo.application.facade.TaskFacade;
import com.demo.domain.model.AdditionalTaskInfo;
import com.demo.domain.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskFacade taskFacade;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO task) {
        Task createdTask = taskFacade.createTask(task.toDomain());
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable("taskId") Long id) {
        return ResponseEntity.of(taskFacade.getTask(id));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskFacade.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody TaskDTO task) {
        return ResponseEntity.of(taskFacade.updateTask(taskId, task.toDomain()));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable("taskId") Long id) {
        if (taskFacade.deleteTask(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{taskId}/additionalInfo")
    public ResponseEntity<AdditionalTaskInfo> getAdditionaltaskInfo(@PathVariable Long taskId) {
        AdditionalTaskInfo additionalTaskInfo = taskFacade.getAdditionalTaskInfo(taskId);
        return ResponseEntity.ok(additionalTaskInfo);
    }
}
