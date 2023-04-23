package com.hcc.services;

import com.hcc.entities.Authority;
import com.hcc.entities.User;
import com.hcc.exceptions.UserNotFoundException;
import com.hcc.repositories.AuthorityRepository;
import com.hcc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorityService {

    @Autowired
    AuthorityRepository authorityRepo;

    @Autowired
    UserRepository userRepo;

    public Optional<User> validateUser(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }
}
