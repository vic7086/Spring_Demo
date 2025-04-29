package com.example.spring_demo_spring_mvc.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
} 