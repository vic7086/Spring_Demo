package com.example.spring_demo_spring_webflux.controller;

import com.example.spring_demo_spring_webflux.model.User;
import com.example.spring_demo_spring_webflux.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureWebTestClient
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll().block();
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setAge(30);

        webTestClient.post()
                .uri("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(user), User.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.name").isEqualTo("John Doe")
                .jsonPath("$.email").isEqualTo("john@example.com")
                .jsonPath("$.age").isEqualTo(30);
    }

    @Test
    void testGetAllUsers() {
        List<User> users = Arrays.asList(
                createUser("John Doe", "john@example.com", 30),
                createUser("Jane Doe", "jane@example.com", 25)
        );

        userRepository.saveAll(users).blockLast();

        webTestClient.get()
                .uri("/api/users")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(User.class)
                .hasSize(2);
    }

    @Test
    void testGetUserById() {
        User user = createUser("John Doe", "john@example.com", 30);
        User savedUser = userRepository.save(user).block();

        webTestClient.get()
                .uri("/api/users/" + savedUser.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo("John Doe")
                .jsonPath("$.email").isEqualTo("john@example.com")
                .jsonPath("$.age").isEqualTo(30);
    }

    @Test
    void testGetUsersByName() {
        List<User> users = Arrays.asList(
                createUser("John Doe", "john@example.com", 30),
                createUser("John Smith", "john.smith@example.com", 35)
        );

        userRepository.saveAll(users).blockLast();

        webTestClient.get()
                .uri("/api/users/name/John")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(User.class)
                .hasSize(2);
    }

    @Test
    void testUpdateUser() {
        User user = createUser("John Doe", "john@example.com", 30);
        User savedUser = userRepository.save(user).block();

        User updatedUser = new User();
        updatedUser.setName("John Updated");
        updatedUser.setEmail("john.updated@example.com");
        updatedUser.setAge(31);

        webTestClient.put()
                .uri("/api/users/" + savedUser.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(updatedUser), User.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo("John Updated")
                .jsonPath("$.email").isEqualTo("john.updated@example.com")
                .jsonPath("$.age").isEqualTo(31);
    }

    @Test
    void testDeleteUser() {
        User user = createUser("John Doe", "john@example.com", 30);
        User savedUser = userRepository.save(user).block();

        webTestClient.delete()
                .uri("/api/users/" + savedUser.getId())
                .exchange()
                .expectStatus().isOk();

        webTestClient.get()
                .uri("/api/users/" + savedUser.getId())
                .exchange()
                .expectStatus().isNotFound();
    }

    private User createUser(String name, String email, int age) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAge(age);
        return user;
    }
} 