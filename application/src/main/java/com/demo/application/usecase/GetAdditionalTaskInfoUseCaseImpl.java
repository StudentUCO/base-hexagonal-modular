package com.demo.application.usecase;

import com.demo.domain.model.AdditionalTaskInfo;
import com.demo.domain.port.in.GetAdditionalTaskInfoUseCase;
import com.demo.domain.port.out.ExternalServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {
    private final ExternalServicePort externalServicePort;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
