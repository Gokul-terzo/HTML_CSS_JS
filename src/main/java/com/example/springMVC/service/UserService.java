package com.example.springMVC.service;

import com.example.springMVC.dto.RegistrationDto;
import com.example.springMVC.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}