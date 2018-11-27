package com.example.graphql.graphqldemo;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
