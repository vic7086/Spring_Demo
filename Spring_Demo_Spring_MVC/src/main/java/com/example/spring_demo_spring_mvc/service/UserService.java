package com.example.spring_demo_spring_mvc.service;

import com.example.spring_demo_spring_mvc.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
} 