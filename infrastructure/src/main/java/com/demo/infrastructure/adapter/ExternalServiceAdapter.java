package com.demo.infrastructure.adapter;

import com.demo.domain.model.AdditionalTaskInfo;
import com.demo.domain.port.out.ExternalServicePort;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalServiceAdapter implements ExternalServicePort {
//    https://jsonplaceholder.typicode.com/todos/
//    https://jsonplaceholder.typicode.com/users/

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        ResponseEntity<JsonPlaceHolderTodo> response = restTemplate.getForEntity(apiUrl, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = response.getBody();

        if (todo == null) {
            return null;
        }

        apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.userId;
        ResponseEntity<JsonPlaceHolderUser> userResponse = restTemplate.getForEntity(apiUrl, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser user = userResponse.getBody();

        if (user == null) {
            return null;
        }

        return AdditionalTaskInfo.build(user.getId(), user.getName(), user.getEmail());
    }

    @Getter
    @Setter
    private static class JsonPlaceHolderTodo {
        private Long id;
        private Long userId;
    }

    @Getter
    @Setter
    private static class JsonPlaceHolderUser {
        private Long id;
        private String name;
        private String email;
    }
}
