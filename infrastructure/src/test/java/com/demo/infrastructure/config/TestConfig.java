package com.demo.infrastructure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("co.demo")
public class TestConfig {
//    @Bean
//    public TaskService taskService(TaskRepositoryPort taskRepositoryPort,
//                                   GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
//        return new TaskService(
//                new CreateTaskUseCaseImpl(taskRepositoryPort),
//                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
//                new UpdateTaskUseCaseImpl(taskRepositoryPort),
//                new DeleteTaskUseCaseImpl(taskRepositoryPort),
//                getAdditionalTaskInfoUseCase
//        );
//    }
//
//    @Bean
//    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepository jpaTaskRepository) {
//        return new JpaTaskRepositoryAdapter(jpaTaskRepository);
//    }
//
//    @Bean
//    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
//        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
//    }
//
//    @Bean
//    public ExternalServicePort externalServicePort() {
//        return new ExternalServiceAdapter();
//    }
}
