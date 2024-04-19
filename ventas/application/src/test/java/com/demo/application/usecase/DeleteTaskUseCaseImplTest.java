package com.demo.application.usecase;

import com.demo.domain.port.in.DeleteTaskUseCase;
import com.demo.domain.port.out.TaskRepositoryPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DeleteTaskUseCaseImplTest {
    @Test
    public void testDeleteTask() {
        // Crear un mock de TaskRepositoryPort
        TaskRepositoryPort mockTaskRepositoryPort = mock(TaskRepositoryPort.class);

        // Configurar el mock para devolver true cuando se llame al método deleteById
        when(mockTaskRepositoryPort.deleteById(any(Long.class))).thenReturn(true);

        // Crear una instancia de la clase a probar con el mock como dependencia
        DeleteTaskUseCase deleteTaskUseCase = new DeleteTaskUseCaseImpl(mockTaskRepositoryPort);

        // Llamar al método a probar
        boolean result = deleteTaskUseCase.deleteTask(1L);

        // Verificar que el método deleteById del mockTaskRepositoryPort se llamó
        verify(mockTaskRepositoryPort, times(1)).deleteById(1L);

        // Realizar aserciones si es necesario
        assertTrue(result);
    }
}