package com.demo.application.usecase;

import com.demo.domain.model.Task;
import com.demo.domain.port.in.RetrieveTaskUseCase;
import com.demo.domain.port.out.TaskRepositoryPort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RetrieveTaskUseCaseImplTest {
    @Test
    public void testGetTask() {
        // Crear un mock de Task
        Task mockTask = mock(Task.class);

        // Crear un mock de TaskRepositoryPort
        TaskRepositoryPort mockTaskRepositoryPort = mock(TaskRepositoryPort.class);

        // Configurar el mock para devolver un Optional de mockTask cuando se llame al método findById
        when(mockTaskRepositoryPort.findById(any(Long.class))).thenReturn(Optional.of(mockTask));

        // Crear una instancia de la clase a probar con el mock como dependencia
        RetrieveTaskUseCase retrieveTaskUseCase = new RetrieveTaskUseCaseImpl(mockTaskRepositoryPort);

        // Llamar al método a probar
        Optional<Task> result = retrieveTaskUseCase.getTask(1L);

        // Verificar que el método findById del mockTaskRepositoryPort se llamó
        verify(mockTaskRepositoryPort, times(1)).findById(1L);

        // Realizar aserciones si es necesario
        assertTrue(result.isPresent());
        assertEquals(mockTask, result.get());
    }

    @Test
    public void testGetAllTasks() {
        // Crear un mock de TaskRepositoryPort
        TaskRepositoryPort mockTaskRepositoryPort = mock(TaskRepositoryPort.class);

        // Configurar el mock para devolver una lista de tareas cuando se llame al método findAll
        when(mockTaskRepositoryPort.findAll()).thenReturn(Arrays.asList(mock(Task.class), mock(Task.class)));

        // Crear una instancia de la clase a probar con el mock como dependencia
        RetrieveTaskUseCase retrieveTaskUseCase = new RetrieveTaskUseCaseImpl(mockTaskRepositoryPort);

        // Llamar al método a probar
        List<Task> result = retrieveTaskUseCase.getAllTasks();

        // Verificar que el método findAll del mockTaskRepositoryPort se llamó
        verify(mockTaskRepositoryPort, times(1)).findAll();

        // Realizar aserciones si es necesario
        assertEquals(2, result.size());
    }
}