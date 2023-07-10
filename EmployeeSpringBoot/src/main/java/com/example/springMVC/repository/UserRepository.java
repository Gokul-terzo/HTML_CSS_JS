package com.example.springMVC.repository;

import com.example.springMVC.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {

}
