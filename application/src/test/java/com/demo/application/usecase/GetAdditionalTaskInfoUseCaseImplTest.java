package com.demo.application.usecase;

import com.demo.domain.model.AdditionalTaskInfo;
import com.demo.domain.port.in.GetAdditionalTaskInfoUseCase;
import com.demo.domain.port.out.ExternalServicePort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class GetAdditionalTaskInfoUseCaseImplTest {
    @Test
    public void testGetAdditionalTaskInfo() {
        // Crear un mock de AdditionalTaskInfo
        AdditionalTaskInfo mockAdditionalTaskInfo = mock(AdditionalTaskInfo.class);

        // Crear un mock de ExternalServicePort
        ExternalServicePort mockExternalServicePort = mock(ExternalServicePort.class);

        // Configurar el mock para devolver el mockAdditionalTaskInfo cuando se llame al método getAdditionalTaskInfo
        when(mockExternalServicePort.getAdditionalTaskInfo(any(Long.class))).thenReturn(mockAdditionalTaskInfo);

        // Crear una instancia de la clase a probar con el mock como dependencia
        GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase = new GetAdditionalTaskInfoUseCaseImpl(mockExternalServicePort);

        // Llamar al método a probar
        AdditionalTaskInfo result = getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(1L);

        // Verificar que el método getAdditionalTaskInfo del mockExternalServicePort se llamó
        verify(mockExternalServicePort, times(1)).getAdditionalTaskInfo(1L);

        // Realizar aserciones si es necesario
        assertEquals(mockAdditionalTaskInfo, result);
    }
}