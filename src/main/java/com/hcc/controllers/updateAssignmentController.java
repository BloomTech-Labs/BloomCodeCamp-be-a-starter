package com.hcc.controllers;

import com.hcc.dto.updateAssignmentRequest;
import com.hcc.entities.Assignment;
import com.hcc.repositories.AssignmentRepository;
import com.hcc.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assignments")
public class updateAssignmentController {
    @Autowired
    AssignmentRepository repository;
    @Autowired
    AssignmentService assignmentService;
    @Autowired
    AssignmentRepository repo;

    public Assignment save(Assignment assignmentId, updateAssignmentRequest request) {

        return assignmentService.updateAssignment(assignmentId, request);
    }
}
