package com.hcc.services;

import com.hcc.entities.User;
import com.hcc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

//    @Autowired
//    CustomPasswordEncoder customPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findByUsername(username);
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(customPasswordEncoder.getPasswordEncoder().encode("password")); // hardcoded password for every user
        return userOptional.orElseThrow(() -> new UsernameNotFoundException( "Invalid Credentials"));
    }
}
