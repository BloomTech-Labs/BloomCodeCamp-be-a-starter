package com.hcc.services;

import com.hcc.dto.updateAssignmentRequest;
import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.repositories.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    private AssignmentRepository assignmentRepository;

    // Constructor injection or autowire the repository
    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<Assignment> getAssignmentsByUser(User userId) {
        // Use the assignment repository to fetch assignments by user ID
        return assignmentRepository.findByUserId(userId);
    }

    public Assignment getAssignmentsById(Long id) {
        // Use the assignment repository to fetch assignments by user ID
        return assignmentRepository.findByAssignmentId(id);
    }
    public void addAssignmentToRepository(Assignment assignment) {
        assignmentRepository.save(assignment);
    }
    public Assignment updateAssignment(Assignment assignment, updateAssignmentRequest request) {
        Assignment assignment1 = getAssignmentsById(assignment.getAssignmentId());
        assignment1.setId(request.getUser().getId());
        assignment1.setNumber(request.getNumber());
        assignment1.setBranch(request.getBranch());
        assignment1.setStatus(request.getStatus());
        assignment1.setUser(request.getUser());
        assignment1.setGithubUrl(request.getGithubUrl());
        assignment1.setCodeReviewer(request.getCodeReviewer());
        assignment1.setReviewVideoUrl(request.getReviewVideoUrl());
        assignmentRepository.save(new Assignment(request.getStatus(), request.getNumber(), request.getGithubUrl(), request.getBranch(), request.getReviewVideoUrl(), request.getUser(), request.getCodeReviewer()));
        return assignment1;
    }

}

