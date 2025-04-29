package com.example.spring_demo_spring_webflux.repository;

import com.example.spring_demo_spring_webflux.model.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends R2dbcRepository<User, Long> {
    Flux<User> findByName(String name);
} 