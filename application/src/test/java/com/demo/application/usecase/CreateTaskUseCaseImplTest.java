package com.demo.application.usecase;

import com.demo.domain.model.Task;
import com.demo.domain.port.in.CreateTaskUseCase;
import com.demo.domain.port.out.TaskRepositoryPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateTaskUseCaseImplTest {
    @Test
    public void testCreateTask() {
        // Crear un mock de Task
        Task mockTask = mock(Task.class);

        // Crear un mock de TaskRepositoryPort
        TaskRepositoryPort mockTaskRepositoryPort = mock(TaskRepositoryPort.class);

        // Configurar el mock para devolver el mockTask cuando se llame al método save
        when(mockTaskRepositoryPort.save(any(Task.class))).thenReturn(mockTask);

        // Crear una instancia de la clase a probar con el mock como dependencia
        CreateTaskUseCase createTaskUseCase = new CreateTaskUseCaseImpl(mockTaskRepositoryPort);

        // Llamar al método a probar
        Task result = createTaskUseCase.createTask(mockTask);

        // Verificar que el método save del mockTaskRepositoryPort se llamó
        verify(mockTaskRepositoryPort, times(1)).save(mockTask);

        // Realizar aserciones si es necesario
        assertEquals(mockTask, result);
    }
}