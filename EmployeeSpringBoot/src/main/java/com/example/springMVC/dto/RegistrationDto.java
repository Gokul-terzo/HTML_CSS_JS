package com.example.springMVC.dto;

import com.example.springMVC.models.Authorities;
import com.example.springMVC.models.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {
    private Users users;
    private Authorities authorities;
}
