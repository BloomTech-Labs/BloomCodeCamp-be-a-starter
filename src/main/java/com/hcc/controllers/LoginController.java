package com.hcc.controllers;

import com.hcc.entities.DTOs.AuthCredentialRequest;
import com.hcc.entities.User;
import com.hcc.services.UserDetailServiceImpl;
import com.hcc.utils.JWtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWtUtils jwtUtils;
    @Autowired
    private UserDetailServiceImpl service;

    @PostMapping(value = "/api/auth/login", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> login(@RequestBody AuthCredentialRequest authCredentialRequestDto) {

        try{
            Authentication authentication = authenticationManager.authenticate
                    (new UsernamePasswordAuthenticationToken(authCredentialRequestDto.getUsername(),
                            authCredentialRequestDto.getPassword()));
            User user = (User) authentication.getPrincipal();
            user.setPassword(null);
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtUtils.generateToken(user)).body("Login SUCCESS");
        } catch (BadCredentialsException exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
