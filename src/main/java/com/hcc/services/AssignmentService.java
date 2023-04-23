package com.hcc.services;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    @Autowired
    AssignmentRepository repository;

    public Optional<List<Assignment>> loadAssignmentsByUser(User user) {
        Long userId = user.getId();
        return repository.findByUserId(userId);
    }

    public Optional<Assignment> loadAssignmentById(Long id) {
        return repository.findById(id);
    }

    public void addNewAssignmentById(Long id) {
        Assignment assignment = Assignment.builder()
                .withId(id)
                .build();
        repository.save(assignment);
    }

    public void updateAssignment(Assignment assignment) {
        repository.save(assignment);
    }
}
