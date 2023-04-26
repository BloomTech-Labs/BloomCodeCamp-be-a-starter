package com.hcc.controllers;

import com.hcc.entities.User;
import com.hcc.utils.JWtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ValidateController {
    @Autowired
    private JWtUtils utils;

    @GetMapping(value = "/api/aut/validate", consumes = {"application/json"}, produces = {"application/json"})
    ResponseEntity<?> validateToken(@RequestParam String token, @AuthenticationPrincipal User user) {
        boolean valid = utils.validateToken(token, (UserDetails) user);
        return new ResponseEntity<>(valid, HttpStatus.OK);
    }
}
