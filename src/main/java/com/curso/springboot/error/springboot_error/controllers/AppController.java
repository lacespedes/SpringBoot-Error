package com.curso.springboot.error.springboot_error.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.curso.springboot.error.springboot_error.models.domain.User;
import com.curso.springboot.error.springboot_error.services.UserService;

@RestController
@RequestMapping("/api")
public class AppController {
    @Autowired
    private UserService userService;
    
    @GetMapping
    public String index() {
        int value = 10 / 0; // Esto generará una excepción de división por cero
        System.out.println("Valor: " + value);
        return "OK 200";
    }


    @GetMapping("/app")
    public String app() {
        int value = Integer.parseInt("abc"); // Esto generará una excepción de formato numérico
        System.out.println("Valor: " + value);
        return "OK 200";
    }

    @GetMapping("/Show")
    public List<User> show() {
        return userService.findAll();
    }

    @GetMapping("/Show/{id}")
    public User show(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @GetMapping("/Show/v2/{id}")
    public ResponseEntity<User> showv2(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user.get());
    }
}
