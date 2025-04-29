package com.example.spring_demo_core_container.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.example.spring_demo_core_container.service.MessageService;
import com.example.spring_demo_core_container.service.SimpleMessageService;

@Configuration
public class AppConfig {
    
    @Bean
    @Scope("singleton")
    public MessageService messageService() {
        SimpleMessageService service = new SimpleMessageService();
        service.setMessage("Message from @Bean configuration!");
        return service;
    }
} 