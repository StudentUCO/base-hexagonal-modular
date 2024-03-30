package com.demo.domain.model;

public class AdditionalTaskInfo {
    private final Long userId;
    private final String userName;
    private final String userEmail;

    private AdditionalTaskInfo(Long userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public static AdditionalTaskInfo build(Long userId, String userName, String userEmail) {
        return new AdditionalTaskInfo(userId, userName, userEmail);
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
