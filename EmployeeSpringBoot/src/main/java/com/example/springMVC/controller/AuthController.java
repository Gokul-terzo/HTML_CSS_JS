package com.example.springMVC.controller;

import com.example.springMVC.dto.RegistrationDto;
import com.example.springMVC.service.AuthoritiesService;
import com.example.springMVC.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private UserService userService;

    private AuthoritiesService authoritiesService;

    public AuthController(UserService userService, AuthoritiesService authoritiesService) {
        this.userService = userService;
        this.authoritiesService = authoritiesService;
    }

    @PostMapping("/register")
    public String addUser(@RequestBody RegistrationDto registrationDto){
        userService.saveUser(registrationDto.getUsers());
        authoritiesService.saveUser(registrationDto.getAuthorities());
        return "Registered!";
    }

}
