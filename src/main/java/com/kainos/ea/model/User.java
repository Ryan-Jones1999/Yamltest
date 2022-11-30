package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    protected int userId;

    protected String email;

    protected String password;

    protected String role;

    @JsonCreator
    public User(@JsonProperty("email") String email,
                @JsonProperty("password") String password,
                @JsonProperty("role") String role) {
        this.setEmail(email);
        this.setPassword(password);
        this.setRole(role);
    }
}
