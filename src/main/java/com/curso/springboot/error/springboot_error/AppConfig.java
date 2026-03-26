package com.curso.springboot.error.springboot_error;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.springboot.error.springboot_error.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    List<User> Users() {
        List<User> users = List.of(
            new User(1L, "John", "Doe"),
            new User(2L, "Jane", "Smith"),
            new User(3L, "Alice", "Johnson"),
            new User(4L, "Bob", "Brown"),
            new User(5L, "Charlie", "Davis")
        );
        return users;
    }
}
