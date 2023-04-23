package com.hcc.controllers;

import com.hcc.exceptions.UserNotFoundException;
import com.hcc.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    AuthorityService service;

    @GetMapping("/api/auth/login")
    ResponseEntity<?> login(@RequestBody String username, @RequestBody String password) {
        service.validateUser(username, password)
                .orElseThrow(UserNotFoundException::new);
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

//    @GetMapping("/api/auth/validate")
//    ResponseEntity<?> ValidateToken(@RequestBody String username, @RequestBody String password) {
//        AuthCredentialRequest.builder().withUsername(username).withPassword(password).build();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
