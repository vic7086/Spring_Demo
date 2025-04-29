package com.example.spring_demo_core_container.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleMessageService implements MessageService {
    
    private String message = "Hello from Spring Container!";
    
    @Override
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
} 