package com.example.spring_demo_spring_batch.config;

import com.example.spring_demo_spring_batch.entity.User;
import org.springframework.batch.item.ItemProcessor;
import java.time.LocalDateTime;

public class UserItemProcessor implements ItemProcessor<User, User> {

    @Override
    public User process(User user) throws Exception {
        user.setProcessedAt(LocalDateTime.now());
        return user;
    }
} 