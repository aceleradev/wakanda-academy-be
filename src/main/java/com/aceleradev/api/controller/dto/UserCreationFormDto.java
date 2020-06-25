package com.aceleradev.api.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserCreationFormDto {

    @NotNull @NotBlank @Size(min = 3,max = 60)
    private String name;
    @Email @NotBlank @NotNull
    private String email;
    @NotNull @NotBlank @Size(min = 3,max = 10)
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
