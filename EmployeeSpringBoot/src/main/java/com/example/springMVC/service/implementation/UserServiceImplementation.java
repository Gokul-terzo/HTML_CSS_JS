package com.example.springMVC.service.implementation;

import com.example.springMVC.models.Users;
import com.example.springMVC.repository.UserRepository;
import com.example.springMVC.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public void saveUser(Users users) {
        userRepository.save(users);
    }

}
