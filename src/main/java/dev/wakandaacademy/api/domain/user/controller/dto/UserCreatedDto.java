package dev.wakandaacademy.api.domain.user.controller.dto;

import dev.wakandaacademy.api.domain.user.model.User;

public class UserCreatedDto {

    private String name;
    private String email;
    
    public UserCreatedDto(String name, String email) {
		this.name = name;
		this.email = email;
	}

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
