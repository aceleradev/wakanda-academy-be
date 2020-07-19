package com.aceleradev.api.controller.dto;

import com.aceleradev.api.domain.model.User;

public class UserCreatedDto {

    private String name;
    private String email;

    public UserCreatedDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
