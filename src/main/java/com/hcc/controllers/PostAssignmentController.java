package com.hcc.controllers;

import com.hcc.entities.Assignment;

import com.hcc.repositories.AssignmentRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/assignments")
public class PostAssignmentController {

    @Autowired
    AssignmentRepository repo;

    public void save(Assignment assignmentId) {
     repo.save(assignmentId);
    }
}

