package com.aceleradev.api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 60, nullable = false)
    private String name;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Credential credential;

    public User() {}

    public User(String name, Credential credential) {
        this.name = name;
        this.credential = credential;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @JsonIgnore
    public String getEmail() {
        return this.credential.getEmail();
    }
    
    
}