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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/auth/validate")
public class validationController {
     //pas the user token to the jwt for authentication using validation
       @Autowired
       UserDetailsService service;
       @Autowired
       AuthenticationManager manager;
       @Autowired
       jwtUtil utils;

       public ResponseEntity<?> validate(@RequestBody AuthCredentialRequest request) {
           Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
           User user = (User) authentication.getPrincipal();
           user.setPassword(null);
           String token = utils.generateToken(user);
           if (utils.validateToken(token, service.loadUserByUsername(user.getUsername()))) {
               return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, utils.generateToken(user)).body(user.getUsername());
           }
           else return ResponseEntity.badRequest().header(HttpHeaders.AUTHORIZATION,utils.generateToken(user)).body(user.getUsername());
       }
}

