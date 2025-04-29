package com.example.spring_demo_spring_security.controller;

import com.example.spring_demo_spring_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String email) {
        try {
            userService.registerUser(username, password, email);
            return "redirect:/login?registered";
        } catch (RuntimeException e) {
            return "redirect:/register?error=" + e.getMessage();
        }
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
} 