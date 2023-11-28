package com.hcc.controllers;

import com.hcc.dto.AuthCredentialRequest;
import com.hcc.entities.User;
import com.hcc.utils.jwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/login")
public class loginController {

    @Autowired
    AuthenticationManager manager;
    @Autowired
    jwtUtil utils;

    // possibly add try catch
    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<?> login(@RequestBody AuthCredentialRequest request) {
        try {
            Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            User user = (User) authentication.getPrincipal();
            user.setPassword(null);
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, utils.generateToken(user)).body(user.getUsername());

        } catch (AuthenticationException e) {
            throw new RuntimeException("invalid username or password");
        }
    }
}

