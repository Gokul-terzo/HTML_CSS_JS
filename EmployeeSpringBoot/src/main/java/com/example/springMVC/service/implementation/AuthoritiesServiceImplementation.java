package com.example.springMVC.service.implementation;

import com.example.springMVC.models.Authorities;
import com.example.springMVC.models.Users;
import com.example.springMVC.repository.AuthoritiesRepository;
import com.example.springMVC.repository.UserRepository;
import com.example.springMVC.service.AuthoritiesService;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesServiceImplementation implements AuthoritiesService {
    private AuthoritiesRepository authoritiesRepository;

    public AuthoritiesServiceImplementation(AuthoritiesRepository authoritiesRepository){
        this.authoritiesRepository=authoritiesRepository;
    }
    @Override
    public void saveUser(Authorities authorities) {
        authoritiesRepository.save(authorities);
    }
}
