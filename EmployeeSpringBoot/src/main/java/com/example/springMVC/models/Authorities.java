package com.example.springMVC.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Authorities {
    @Id
    private String username;
    private String role;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private Users users;
}
