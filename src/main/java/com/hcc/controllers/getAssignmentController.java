package com.hcc.controllers;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/assignments/{id}")
public class getAssignmentController {
    @Autowired
    AssignmentService assignment;

    public List<Assignment> getAssignmentsByUser(@PathVariable User userId) {
        List<Assignment> assignments = assignment.getAssignmentsByUser(userId);

        return assignments;
    }
    public Assignment getAssignmentsByID(@PathVariable Long id) {
        Assignment assignments = assignment.getAssignmentsById(id);
        return assignments;
    }
}

