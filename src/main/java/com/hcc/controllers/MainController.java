package com.hcc.controllers;

import com.hcc.entities.Assignment;
import com.hcc.entities.Authority;
import com.hcc.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    //TODO find out what needs to be put in the parameters and inside the method bodies.
    @GetMapping("/api/auth/login")
    ResponseEntity<?> login(@RequestBody User user) {
        return null;
    }

    @GetMapping("/api/auth/validate")
    ResponseEntity<?> ValidateToken(@RequestBody Authority authority) {
        return null;
    }

    @GetMapping(value = "/api/assignments", produces = {"application/json"})
    ResponseEntity<?> GetAssignmentsByUser(@RequestBody Assignment assignment) {
        return null;
    }

    @GetMapping(value = "/api/assignments/{id}", produces = {"application.json"})
    ResponseEntity<?> GetAssignmentsById(@PathVariable String id) {
        return null;
    }

    @PutMapping(value = "/api/assignments/{id}", produces = {"application/json"})
    ResponseEntity<?> PutAssignmentById(@PathVariable String id) {
        return null;
    }

    @PostMapping(value = "/api/assignments", produces = {"application/json"})
    ResponseEntity<?> postAssignment(@Validated @RequestBody Assignment assignment) {
        return null;
    }

}
