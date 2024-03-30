package com.demo.application.service;

import com.demo.domain.model.AdditionalTaskInfo;
import com.demo.domain.model.Task;
import com.demo.domain.port.in.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private CreateTaskUseCase createTaskUseCase;

    @Mock
    private RetrieveTaskUseCase retrieveTaskUseCase;

    @Mock
    private UpdateTaskUseCase updateTaskUseCase;

    @Mock
    private DeleteTaskUseCase deleteTaskUseCase;

    @Mock
    private GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void testCreateTask() {
        // Crear un mock de Task
        Task mockTask = mock(Task.class);

        // Configurar el mock para devolver el mockTask cuando se llame al método createTask
        when(createTaskUseCase.createTask(any(Task.class))).thenReturn(mockTask);

        // Llamar al método a probar
        Task result = taskService.createTask(mockTask);

        // Verificar que el método createTask del mockCreateTaskUseCase se llamó
        verify(createTaskUseCase, times(1)).createTask(mockTask);

        // Realizar aserciones si es necesario
        assertEquals(mockTask, result);
    }

    @Test
    public void testDeleteTask() {
        // Configurar el mock para devolver true cuando se llame al método deleteTask
        when(deleteTaskUseCase.deleteTask(any(Long.class))).thenReturn(true);

        // Llamar al método a probar
        boolean result = taskService.deleteTask(1L);

        // Verificar que el método deleteTask del mockDeleteTaskUseCase se llamó
        verify(deleteTaskUseCase, times(1)).deleteTask(1L);

        // Realizar aserciones si es necesario
        assertTrue(result);
    }

    @Test
    public void testGetAdditionalTaskInfo() {
        // Crear un mock de AdditionalTaskInfo
        AdditionalTaskInfo mockAdditionalTaskInfo = mock(AdditionalTaskInfo.class);

        // Configurar el mock para devolver el mockAdditionalTaskInfo cuando se llame al método getAdditionalTaskInfo
        when(getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(any(Long.class))).thenReturn(mockAdditionalTaskInfo);

        // Llamar al método a probar
        AdditionalTaskInfo result = taskService.getAdditionalTaskInfo(1L);

        // Verificar que el método getAdditionalTaskInfo del mockGetAdditionalTaskInfoUseCase se llamó
        verify(getAdditionalTaskInfoUseCase, times(1)).getAdditionalTaskInfo(1L);

        // Realizar aserciones si es necesario
        assertEquals(mockAdditionalTaskInfo, result);
    }

    @Test
    public void testGetTask() {
        // Crear un mock de Task
        Task mockTask = mock(Task.class);

        // Configurar el mock para devolver un Optional de mockTask cuando se llame al método getTask
        when(retrieveTaskUseCase.getTask(any(Long.class))).thenReturn(Optional.of(mockTask));

        // Llamar al método a probar
        Optional<Task> result = taskService.getTask(1L);

        // Verificar que el método getTask del mockRetrieveTaskUseCase se llamó
        verify(retrieveTaskUseCase, times(1)).getTask(1L);

        // Realizar aserciones si es necesario
        assertTrue(result.isPresent());
        assertEquals(mockTask, result.get());
    }

    @Test
    public void testGetAllTasks() {
        // Configurar el mock para devolver una lista de tareas cuando se llame al método getAllTasks
        when(retrieveTaskUseCase.getAllTasks()).thenReturn(Arrays.asList(mock(Task.class), mock(Task.class)));

        // Llamar al método a probar
        List<Task> result = taskService.getAllTasks();

        // Verificar que el método getAllTasks del mockRetrieveTaskUseCase se llamó
        verify(retrieveTaskUseCase, times(1)).getAllTasks();

        // Realizar aserciones si es necesario
        assertEquals(2, result.size());
    }

    @Test
    public void testUpdateTask() {
        // Crear un mock de Task
        Task mockTask = mock(Task.class);

        // Configurar el mock para devolver un Optional de mockTask cuando se llame al método updateTask
        when(updateTaskUseCase.updateTask(any(Long.class), any(Task.class))).thenReturn(Optional.of(mockTask));

        // Llamar al método a probar
        Optional<Task> result = taskService.updateTask(1L, mockTask);

        // Verificar que el método updateTask del mockUpdateTaskUseCase se llamó
        verify(updateTaskUseCase, times(1)).updateTask(1L, mockTask);

        // Realizar aserciones si es necesario
        assertTrue(result.isPresent());
        assertEquals(mockTask, result.get());
    }
}