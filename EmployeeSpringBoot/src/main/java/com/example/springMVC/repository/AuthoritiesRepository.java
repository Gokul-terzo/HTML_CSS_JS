package com.example.springMVC.repository;

import com.example.springMVC.models.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities,String> {
}
