package com.example.springsec1.controller;

import com.example.springsec1.entity.Users;
import com.example.springsec1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class AuthController {
    private final UserService service;

    @PostMapping
    public Users register(@RequestBody Users users){
        return service.createUser(users);
    }
}
