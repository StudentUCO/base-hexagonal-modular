package com.demo.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AdditionalTaskInfoTest {
    @Test
    public void testBuild() {
        Long userId = 1L;
        String userName = "Test User";
        String userEmail = "testuser@example.com";

        AdditionalTaskInfo additionalTaskInfo = AdditionalTaskInfo.build(userId, userName, userEmail);

        assertNotNull(additionalTaskInfo);
        assertEquals(userId, additionalTaskInfo.getUserId());
        assertEquals(userName, additionalTaskInfo.getUserName());
        assertEquals(userEmail, additionalTaskInfo.getUserEmail());
    }
}