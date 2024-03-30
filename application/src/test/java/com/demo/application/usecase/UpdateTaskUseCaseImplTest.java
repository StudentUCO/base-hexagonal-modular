package com.demo.application.usecase;

import com.demo.domain.model.Task;
import com.demo.domain.port.in.UpdateTaskUseCase;
import com.demo.domain.port.out.TaskRepositoryPort;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UpdateTaskUseCaseImplTest {
    @Test
    public void testUpdateTask() {
        // Crear un mock de Task
        Task mockTask = mock(Task.class);

        // Crear un mock de TaskRepositoryPort
        TaskRepositoryPort mockTaskRepositoryPort = mock(TaskRepositoryPort.class);

        // Configurar el mock para devolver un Optional de mockTask cuando se llame al método update
        when(mockTaskRepositoryPort.update(any(Task.class))).thenReturn(Optional.of(mockTask));

        // Crear una instancia de la clase a probar con el mock como dependencia
        UpdateTaskUseCase updateTaskUseCase = new UpdateTaskUseCaseImpl(mockTaskRepositoryPort);

        // Llamar al método a probar
        Optional<Task> result = updateTaskUseCase.updateTask(1L, mockTask);

        // Verificar que el método update del mockTaskRepositoryPort se llamó
        verify(mockTaskRepositoryPort, times(1)).update(mockTask);

        // Realizar aserciones si es necesario
        assertTrue(result.isPresent());
        assertEquals(mockTask, result.get());
    }
}