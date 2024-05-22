package com.kube.rodo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
    public HelloWorldRestController() {
    }

    @GetMapping({"/hola/{userName}"})
    public String hello(@PathVariable String userName) {
        System.out.println("Ejecutando el metodo saludo con devtool");
        return "Hello " + userName;
    }
}
