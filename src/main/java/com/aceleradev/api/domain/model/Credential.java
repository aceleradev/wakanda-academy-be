package com.aceleradev.api.domain.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "credentials")
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 60, nullable = false)
    private String password;
    @Email @Column(unique = true)
    private String email;

    public Credential() {}

    public Credential(String password, @Email String email) {
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
