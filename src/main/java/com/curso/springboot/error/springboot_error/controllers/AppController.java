package com.curso.springboot.error.springboot_error.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {
    @RequestMapping("/index")
    public String index() {
        int value = 10 / 0; // Esto generará una excepción de división por cero
        System.out.println("Valor: " + value);
        return "OK 200";
    }


    @RequestMapping("/app")
    public String app() {
        int value = Integer.parseInt("abc"); // Esto generará una excepción de formato numérico
        System.out.println("Valor: " + value);
        return "OK 200";
    }
}
