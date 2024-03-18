package org.test.app.controllers;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {


    @GetMapping("/users")
    public List<String> getAllUsers(){
        return List.of("Ajeet", "Ashish", "Amit", "Ajay");
    }

    @GetMapping("/users/{id}")
    public String getSingleUser(){
        return "ajeet";
    }
}
